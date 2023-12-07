package edu.pr3.counters;

import edu.pr3.logs.LogInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ResourcesMetricCounter implements LogMetricCounter<ResourcesMetricCounter.ResourcesMetric[]> {
    private static final int POPULAR_COUNT = 5;

    @Override
    public ResourcesMetric[] countMetric(LogInfo[] logs) {
        return getFiveMostPopularPaths(Arrays.stream(logs)
                .collect(Collectors.groupingBy(log -> log.responseInfo.path, Collectors.counting())));
    }

    private ResourcesMetric[] getFiveMostPopularPaths(Map<String, Long> pathCounts) {
        return pathCounts.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(POPULAR_COUNT)
                .map(x -> new ResourcesMetric(x.getKey(), x.getValue()))
                .toArray(ResourcesMetric[]::new);
    }

    public record ResourcesMetric(String path, Long count) {
    }
}
