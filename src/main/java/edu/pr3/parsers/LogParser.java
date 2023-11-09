package edu.pr3.parsers;

import edu.pr3.logs.HttpMethod;
import edu.pr3.logs.HttpResponseInfo;
import edu.pr3.logs.LogInfo;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

@SuppressWarnings("all")
public class LogParser {
    private final static Pattern LOG_PATTERN =
            Pattern.compile(
                    "^([^ ]*) - - \\[(.*)\\] \"([^ ]*) ([^ ]*) ([^ ]*)\" " +
                            "(-|[0-9]*) (-|[0-9]*) \"(.+?|-)\" \"(.+?|-)\"$");
    private final static DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MMMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    public static void main(String[] args) {
        new LogParser().parse(null);
    }

    public LogInfo parse(String log) {
        var matcher = LOG_PATTERN.matcher(log);
        if (matcher.find()) {
            var date = parseDate(matcher.group(2));
            var ip = matcher.group(1);
            var httpMethod = getMethod(matcher.group(3));
            var uri = matcher.group(4);
            var version = matcher.group(5);
            var statusCode = Integer.parseInt(matcher.group(6));
            var bytesSent = Integer.parseInt(matcher.group(7));
            var client = matcher.group(9);
            var responseInfo = new HttpResponseInfo(httpMethod, uri, version, statusCode, bytesSent);
            return new LogInfo(ip, date, responseInfo, client);
        }
        return null;
    }

    private OffsetDateTime parseDate(String date) {
        return OffsetDateTime.parse(date, FORMATTER);
    }

    private HttpMethod getMethod(String method) {
        return HttpMethod.valueOf(method);
    }
}
