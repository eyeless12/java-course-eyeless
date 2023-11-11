package edu.pr3;

import edu.pr3.logs.HttpMethod;
import edu.pr3.parsers.LogParser;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import static org.assertj.core.api.Assertions.assertThat;

public class LogParserTests {
    @Test
    void testParser() {
        var parser = new LogParser();
        var log = "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"";
        var logInfo = parser.parse(log);

        assertThat(logInfo).isNotNull();
        assertThat(logInfo.remoteIp).isEqualTo("93.180.71.3");
        assertThat(logInfo.userClient).isEqualTo("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)");
        assertThat(logInfo.dateTime).isEqualTo(OffsetDateTime.of(2015, 5, 17, 8, 5, 32, 0, ZoneOffset.UTC));
        assertThat(logInfo.responseInfo.bytesSent).isEqualTo(0);
        assertThat(logInfo.responseInfo.statusCode).isEqualTo(304);
        assertThat(logInfo.responseInfo.path).isEqualTo("/downloads/product_1");
        assertThat(logInfo.responseInfo.httpMethod).isEqualTo(HttpMethod.GET);
        assertThat(logInfo.responseInfo.httpVersion).isEqualTo("HTTP/1.1");
    }
}
