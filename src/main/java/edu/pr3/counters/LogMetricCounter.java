package edu.pr3.counters;

import edu.pr3.logs.LogInfo;

public interface LogMetricCounter<T> {
    T countMetric(LogInfo[] logs);
}
