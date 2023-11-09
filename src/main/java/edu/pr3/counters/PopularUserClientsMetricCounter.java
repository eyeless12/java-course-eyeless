package edu.pr3.counters;

import edu.pr3.logs.LogInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class PopularUserClientsMetricCounter
        implements LogMetricCounter<PopularUserClientsMetricCounter.UserClientMetric[]> {
    private static final int POPULAR_COUNT = 5;

    @Override
    public UserClientMetric[] countMetric(LogInfo[] logs) {
        return getFiveMostPopularClients(Arrays.stream(logs)
                .collect(Collectors.groupingBy(log -> log.userClient, Collectors.counting())));
    }

    private UserClientMetric[] getFiveMostPopularClients(
            Map<String, Long> clientCounts) {
        return clientCounts.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(POPULAR_COUNT)
                .map(x -> new UserClientMetric(x.getKey(), x.getValue()))
                .toArray(UserClientMetric[]::new);
    }

    public record UserClientMetric(String client, long count) {
    }
}
