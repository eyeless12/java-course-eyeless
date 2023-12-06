package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class DurationParser {
    private DurationParser() { }

    private static final String REGEX =
            "^(\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2})$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    public static String getDuration(String duration) {
        var matcher = PATTERN.matcher(duration);

        if (matcher.find()) {
            var firstDateTime = matcher.group(1);
            var secondDateTime = matcher.group(2);
            var first = LocalDateTime.parse(firstDateTime, FORMATTER);
            var second = LocalDateTime.parse(secondDateTime, FORMATTER);
            var a = Duration.between(first, second);
            return String.format("%dч %dм", a.toHoursPart(), a.toMinutesPart());
        }
        return null;
    }
}
