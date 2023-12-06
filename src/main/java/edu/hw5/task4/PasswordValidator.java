package edu.hw5.task4;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final Pattern PATTERN = Pattern.compile("^(?=.*[~!@#$%^&*|]).*$");

    private PasswordValidator() { }

    public static boolean validate(String password) {
       return PATTERN.matcher(password).find();
    }
}
