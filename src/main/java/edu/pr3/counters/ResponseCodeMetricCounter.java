package edu.pr3.counters;

import edu.pr3.logs.LogInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseCodeMetricCounter implements LogMetricCounter<ResponseCodeMetricCounter.ResponseCodeMetric[]> {
    private static final int POPULAR_COUNT = 5;

    @Override
    public ResponseCodeMetric[] countMetric(LogInfo[] logs) {
        return getFiveMostPopularCodes(Arrays.stream(logs)
                .collect(Collectors.groupingBy(log -> log.responseInfo.statusCode, Collectors.counting())));
    }

    private ResponseCodeMetricCounter.ResponseCodeMetric[] getFiveMostPopularCodes(
            Map<Integer, Long> statusCodeCounts) {
        return statusCodeCounts.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(POPULAR_COUNT)
                .map(x -> new ResponseCodeMetric(x.getKey(), x.getValue()))
                .toArray(ResponseCodeMetric[]::new);
    }

    public record ResponseCodeMetric(int responseCode, long count) {
    }
}
