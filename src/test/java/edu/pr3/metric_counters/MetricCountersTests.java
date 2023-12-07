package edu.pr3.metric_counters;

import edu.pr3.counters.AverageResponseSizeMetricCounter;
import edu.pr3.counters.HttpMethodMetricCounter;
import edu.pr3.counters.LogMetricCounter;
import edu.pr3.counters.PopularUserClientsMetricCounter;
import edu.pr3.counters.RequestMetricCounter;
import edu.pr3.counters.ResourcesMetricCounter;
import edu.pr3.counters.ResponseCodeMetricCounter;
import edu.pr3.logs.HttpMethod;
import edu.pr3.logs.LogInfo;
import edu.pr3.parsers.LogParser;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class MetricCountersTests {
    private final LogInfo[] logs;
    public MetricCountersTests() throws IOException {
        var parser = new LogParser();
        var logStrings = Files.readAllLines(Path.of("./test_files/nginx_logs_small.txt"));
        logs = logStrings.stream().map(parser::parse).toArray(LogInfo[]::new);
    }

    @Test
    void testAverageResponseSizeCounter() {
        var counter = new AverageResponseSizeMetricCounter();
        var result = counter.countMetric(logs);
        assertThat(result).isEqualByComparingTo(435948.0946517892);
    }

    @Test
    void testHttpMethodCounter() {
        var counter = new HttpMethodMetricCounter();
        var result = counter.countMetric(logs);
        assertThat(result.length).isEqualTo(2);
        assertThat(Arrays.stream(result).map(x -> x.method())).containsExactly(HttpMethod.GET, HttpMethod.HEAD);
        assertThat(Arrays.stream(result).map(x -> x.count())).containsExactly(5156L, 42L);
    }

    @Test
    void testUserClientsCounter() {
        var counter = new PopularUserClientsMetricCounter();
        var result = counter.countMetric(logs);
        var expected = new PopularUserClientsMetricCounter.UserClientMetric[] {
            new PopularUserClientsMetricCounter.UserClientMetric("Debian APT-HTTP/1.3 (0.9.7.9)", 1270),
            new PopularUserClientsMetricCounter.UserClientMetric("Debian APT-HTTP/1.3 (1.0.1ubuntu2)", 1186),
            new PopularUserClientsMetricCounter.UserClientMetric("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)", 665),
            new PopularUserClientsMetricCounter.UserClientMetric("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)", 385),
            new PopularUserClientsMetricCounter.UserClientMetric("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.22)", 313),
        };
        assertThat(result.length).isEqualTo(5);
        assertThat(result).containsExactly(expected);
    }

    @Test
    void testRequestCounter() {
        var counter = new RequestMetricCounter();
        var result = counter.countMetric(logs);
        assertThat(result).isEqualTo(String.valueOf(logs.length));
    }

    @Test
    void testResourcesCounter() {
        var counter = new ResourcesMetricCounter();
        var result = counter.countMetric(logs);
        var expected = new ResourcesMetricCounter.ResourcesMetric[] {
            new ResourcesMetricCounter.ResourcesMetric("/downloads/product_1", 2827L),
            new ResourcesMetricCounter.ResourcesMetric("/downloads/product_2", 2367L),
            new ResourcesMetricCounter.ResourcesMetric("/downloads/product_3", 4L)
        };

        assertThat(result.length).isEqualTo(3);
        assertThat(result).containsExactly(expected);
    }

    @Test
    void testResponseCodesCounter() {
        var counter = new ResponseCodeMetricCounter();
        var result = counter.countMetric(logs);
        var expected = new ResponseCodeMetricCounter.ResponseCodeMetric[] {
            new ResponseCodeMetricCounter.ResponseCodeMetric(404, 3459L),
            new ResponseCodeMetricCounter.ResponseCodeMetric(304, 1352L),
            new ResponseCodeMetricCounter.ResponseCodeMetric(200, 365L),
            new ResponseCodeMetricCounter.ResponseCodeMetric(403, 15L),
            new ResponseCodeMetricCounter.ResponseCodeMetric(206, 7L),
        };
        assertThat(result.length).isEqualTo(5);
        assertThat(result).containsExactly(expected);
    }
}
