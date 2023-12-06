package edu.hw5.task7;

import java.util.regex.Pattern;

public class Regexes {
    private Regexes() {}

    private static final Pattern PATTERN_ONE = Pattern.compile("^(1|0){2}0.*$");
    private static final Pattern PATTERN_TWO = Pattern.compile("^(0|1).*\\1$");
    private static final Pattern PATTERN_THREE = Pattern.compile("^(0|1){1,3}$");

    public static boolean findOne(String input) {
        return PATTERN_ONE.matcher(input).find();
    }

    public static boolean findTwo(String input) {
        return PATTERN_TWO.matcher(input).find();
    }

    public static boolean findThree(String input) {
        return PATTERN_THREE.matcher(input).find();
    }
}
