package edu.pr3.writers;

import edu.pr3.logs.LogInfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("all")
public class AdocWriter extends LogResultWriter {
    public AdocWriter() {
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
                "[cols=\"1,1\"]\n" +
                "|===\n" +
                "|Metric |Value\n" +
                "|Requests\n" +
                "|" + requestMetricCounter.countMetric(logs) + "\n" +
                "\n" +
                "|Response size\n" +
                "|" + averageResponseSizeMetricCounter.countMetric(logs) + "\n" +
                "|===\n";
    }

    private String getPopularResourcesTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular resources\n");
        resultSb.append("""
                [cols="1,1"]
                |===
                """);
        resultSb.append("|Resource |Requests\n");
        for (var result : resourcesMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("|%s\n|%s\n\n", result.path(), result.count()));
        }
        resultSb.append("|===\n");
        return resultSb.toString();
    }

    private String getResponesCodeTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular response codes\n");
        resultSb.append("""
                [cols="1,1"]
                |===
                """);
        resultSb.append("|Code |Count\n");
        for (var result : responseCodeMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("|%s\n|%s\n\n", result.responseCode(), result.count()));
        }
        resultSb.append("|===\n");
        return resultSb.toString();
    }

    private String getUserClientTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular response codes\n");
        resultSb.append("""
                [cols="1,1"]
                |===
                """);
        resultSb.append("|Client |Count\n");
        for (var result : popularUserClientsMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("|%s\n|%s\n\n", result.client(), result.count()));
        }
        resultSb.append("|===\n");
        return resultSb.toString();
    }

    private String getHttpMethodTable(LogInfo[] logs) {
        var resultSb = new StringBuilder();
        resultSb.append("## Popular response codes\n");
        resultSb.append("""
                [cols="1,1"]
                |===
                """);
        resultSb.append("|Method |Count\n");
        for (var result : httpMethodMetricCounter.countMetric(logs)) {
            resultSb.append(String.format("|%s\n|%s\n\n", result.method(), result.count()));
        }
        resultSb.append("|===\n");
        return resultSb.toString();
    }
}
