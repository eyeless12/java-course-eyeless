package edu.hw9.task1;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StatsCollector {

    private static final String DELIMITER = " : ";
    private static final int NUMBER_OF_THREADS = 5;
    private final AtomicInteger metricsCounter = new AtomicInteger(0);
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    @Getter
    private final Map<String, Statistic> stats = new ConcurrentHashMap<>();
    private final BlockingQueue<Metric> metricsToProcess = new LinkedBlockingQueue<>();

    public StatsCollector() {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.submit(this::processMetrics);
        }
    }

    @SneakyThrows
    public void push(Metric metric) {
        if (executorService.isShutdown()) {
            throw new IllegalStateException("ExecutorService is shut downed and cant process new metrics");
        }
        metricsCounter.incrementAndGet();
        metricsToProcess.put(metric);
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    @SneakyThrows
    public void printStats() {
        executorService.shutdown();
        while (metricsCounter.get() != 0) {
        }
        for (var entry : stats.entrySet()) {
            System.out.println(entry.getKey() + DELIMITER + entry.getValue());
        }
    }

    @SneakyThrows
    private void processMetrics() {
        while (!executorService.isShutdown()) {
            Metric currentMetric = metricsToProcess.take();
            Statistic stat = getStat(currentMetric.values());
            stats.put(currentMetric.name(), stat);
            metricsCounter.decrementAndGet();
        }
    }

    private Statistic getStat(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double summ = 0;
        for (double value : values) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            summ += value;
        }
        return new Statistic(summ, summ / values.length, min, max);
    }
}