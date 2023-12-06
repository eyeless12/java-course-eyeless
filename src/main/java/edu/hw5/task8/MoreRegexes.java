package edu.hw5.task8;

import java.util.regex.Pattern;

public class MoreRegexes {
    private MoreRegexes() {}

    private static final Pattern PATTERN_ONE = Pattern.compile("^(0|1)(01)*$");
    private static final Pattern PATTERN_TWO = Pattern.compile("^(0(01)*1|1(01)*0)$");
    private static final Pattern PATTERN_THREE = Pattern.compile("^(1*01*01*)*$");
    private static final Pattern PATTERN_FOUR = Pattern.compile("^(0*|0*10+)*$");
    private static final Pattern PATTERN_FIVE = Pattern.compile("^((1|00)*1)*$");
    private static final Pattern PATTERN_SIX = Pattern.compile("^(1*01*01*){2,}$");
    private static final Pattern PATTERN_SEVEN = Pattern.compile("^(0|10)*$");

    public static boolean findOne(String input) {
        return PATTERN_ONE.matcher(input).find();
    }

    public static boolean findTwo(String input) {
        return PATTERN_TWO.matcher(input).find();
    }

    public static boolean findThree(String input) {
        return PATTERN_THREE.matcher(input).find();
    }

    public static boolean findFour(String input) {
        return PATTERN_FOUR.matcher(input).find();
    }

    public static boolean findFive(String input) {
        return PATTERN_FIVE.matcher(input).find();
    }

    public static boolean findSix(String input) {
        return PATTERN_SIX.matcher(input).find();
    }

    public static boolean findSeven(String input) {
        return PATTERN_SEVEN.matcher(input).find();
    }
}
