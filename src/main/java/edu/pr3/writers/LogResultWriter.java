package edu.pr3.writers;

import edu.pr3.counters.AverageResponseSizeMetricCounter;
import edu.pr3.counters.HttpMethodMetricCounter;
import edu.pr3.counters.PopularUserClientsMetricCounter;
import edu.pr3.counters.RequestMetricCounter;
import edu.pr3.counters.ResourcesMetricCounter;
import edu.pr3.counters.ResponseCodeMetricCounter;
import edu.pr3.logs.LogInfo;
import java.io.IOException;
import java.nio.file.Path;

public abstract class LogResultWriter {
    protected final AverageResponseSizeMetricCounter averageResponseSizeMetricCounter;
    protected final RequestMetricCounter requestMetricCounter;
    protected final ResourcesMetricCounter resourcesMetricCounter;
    protected final ResponseCodeMetricCounter responseCodeMetricCounter;
    protected final PopularUserClientsMetricCounter popularUserClientsMetricCounter;
    protected final HttpMethodMetricCounter httpMethodMetricCounter;

    public LogResultWriter() {
        averageResponseSizeMetricCounter = new AverageResponseSizeMetricCounter();
        requestMetricCounter = new RequestMetricCounter();
        resourcesMetricCounter = new ResourcesMetricCounter();
        responseCodeMetricCounter = new ResponseCodeMetricCounter();
        popularUserClientsMetricCounter = new PopularUserClientsMetricCounter();
        httpMethodMetricCounter = new HttpMethodMetricCounter();
    }

    public abstract void writeResultsToFile(LogInfo[] logs, Path path) throws IOException;
}
