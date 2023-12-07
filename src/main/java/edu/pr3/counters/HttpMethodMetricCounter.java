package edu.pr3.counters;

import edu.pr3.logs.HttpMethod;
import edu.pr3.logs.LogInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpMethodMetricCounter implements LogMetricCounter<HttpMethodMetricCounter.HttpMethodMetric[]> {
    private static final int POPULAR_COUNT = 5;

    @Override
    public HttpMethodMetric[] countMetric(LogInfo[] logs) {
        return getFiveMostPopularMethods(Arrays.stream(logs)
                .collect(Collectors.groupingBy(log -> log.responseInfo.httpMethod, Collectors.counting())));
    }

    private HttpMethodMetric[] getFiveMostPopularMethods(
            Map<HttpMethod, Long> clientCounts) {
        return clientCounts.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(POPULAR_COUNT)
                .map(x -> new HttpMethodMetric(x.getKey(), x.getValue()))
                .toArray(HttpMethodMetric[]::new);
    }

    public record HttpMethodMetric(HttpMethod method, long count) {
    }
}
