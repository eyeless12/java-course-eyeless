package edu.pr3.writers;

import edu.pr3.logs.LogInfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("all")
public class MdWriter extends LogResultWriter {
    public MdWriter() {
        super();
    }

    @Override
    public void writeResultsToFile(LogInfo[] logs, Path path) throws IOException {
        String resultSb = getBasicMetricsTable(logs)
                + getPopularResourcesTable(logs)
                + getResponesCodeTable(logs)
                + getUserClientTable(logs)
                + getHttpMethodTable(logs);
        try {
            Files.createFile(path);
        } catch (IOException ignored) {
        }
        Files.writeString(path, resultSb);
    }

    private String getBasicMetricsTable(LogInfo[] logs) {

        return "## Log metrics\n" +
                "| Metric           | Value |\n" +
                "| :--------------- | :---: |\n" +
                String.format("| Requests        |   %s   |\n", requestMetricCounter.countMetric(logs)) +
                String.format("| Response size        |   %s   |\n",
                        averageResponseSizeMetricCounter.countMetric(logs));
    }

    private String getPopularResourcesTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular resources\n");
        resultSb.append("| Resource           | Requests |\n");
        resultSb.append("| :--------------- | :---: |\n");
        for (var result : resourcesMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("%s | %s |\n", result.path(), result.count()));
        }
        return resultSb.toString();
    }

    private String getResponesCodeTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular response codes\n");
        resultSb.append("| Code           | Count |\n");
        resultSb.append("| :------------- | :---: |\n");
        for (var result : responseCodeMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("%s | %s |\n", result.responseCode(), result.count()));
        }
        return resultSb.toString();
    }

    private String getUserClientTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular user clients\n");
        resultSb.append("| Client          | Count |\n");
        resultSb.append("| :-------------- | :---: |\n");
        for (var result : popularUserClientsMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("%s | %s |\n", result.client(), result.count()));
        }
        return resultSb.toString();
    }

    private String getHttpMethodTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular methods\n");
        resultSb.append("| Method          | Count |\n");
        resultSb.append("| :-------------- | :---: |\n");
        for (var result : httpMethodMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("%s | %s |\n", result.method(), result.count()));
        }
        return resultSb.toString();
    }
}
