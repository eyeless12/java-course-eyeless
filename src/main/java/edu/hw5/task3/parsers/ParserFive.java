package edu.hw5.task3.parsers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParserFive implements DateParser {
    private static final String REGEX = "^tomorrow$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    @Override
    public Optional<LocalDate> tryParse(String date) {
        var matcher = PATTERN.matcher(date);
        if (!matcher.find()) {
            return Optional.empty();
        }
        return Optional.of(LocalDate.now().plusDays(1));
    }
}
