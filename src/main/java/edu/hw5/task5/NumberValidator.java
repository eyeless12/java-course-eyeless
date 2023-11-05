package edu.hw5.task5;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final Pattern PATTERN = Pattern.compile("^[А-Я]\\d{3}[А-Я][А-Я]\\d{3}$");

    private NumberValidator() { }

    public static boolean validate(String number) {
        return PATTERN.matcher(number).find();
    }
}
