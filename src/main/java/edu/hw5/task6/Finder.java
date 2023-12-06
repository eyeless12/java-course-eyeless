package edu.hw5.task6;

import java.util.regex.Pattern;

public class Finder {
    private Finder() { }

    public static boolean isSubsequence(String subsequence, String string) {
        return Pattern.compile(subsequence).matcher(string).find();
    }
}
