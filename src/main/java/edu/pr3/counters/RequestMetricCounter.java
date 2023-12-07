package edu.pr3.counters;

import edu.pr3.logs.LogInfo;

public class RequestMetricCounter implements LogMetricCounter<String> {
    @Override
    public String countMetric(LogInfo[] logs) {
        return String.valueOf(logs.length);
    }
}
