package edu.hw5.task3.parsers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class ParserFour implements DateParser {
    private static final String REGEX = "^(\\d{1})/(\\d{1})/(\\d{2})$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private static final int TWO_THOUSANDS = 2000;
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
                TWO_THOUSANDS + Integer.parseInt(matcher.group(GROUP_THREE)),
                Integer.parseInt(matcher.group(GROUP_TWO)),
                Integer.parseInt(matcher.group(GROUP_ONE))));
    }
}
