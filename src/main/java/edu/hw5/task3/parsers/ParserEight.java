package edu.hw5.task3.parsers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParserEight implements DateParser {
    private static final String REGEX = "^(\\d+) day(s)? ago$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    @Override
    public Optional<LocalDate> tryParse(String date) {
        var matcher = PATTERN.matcher(date);
        if (!matcher.find()) {
            return Optional.empty();
        }
        return Optional.of(LocalDate.now().minusDays(Integer.parseInt(matcher.group(1))));
    }
}

