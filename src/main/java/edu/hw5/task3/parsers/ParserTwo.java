package edu.hw5.task3.parsers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParserTwo implements DateParser {
    private static final String REGEX = "^(\\d{4})-(\\d{2})-(\\d)$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final int GROUP_THREE = 3;
    private static final int GROUP_TWO = 2;
    private static final int GROUP_ONE = 1;

    @Override
    public Optional<LocalDate> tryParse(String date) {
        var matcher = PATTERN.matcher(date);
        if (!matcher.find()) {
            return Optional.empty();
        }
        return Optional.of(LocalDate.of(
                Integer.parseInt(matcher.group(GROUP_ONE)),
                Integer.parseInt(matcher.group(GROUP_TWO)),
                Integer.parseInt(matcher.group(GROUP_THREE))));
    }
}
