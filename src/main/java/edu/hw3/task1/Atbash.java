package edu.hw3.task1;

import java.util.ArrayList;

public class Atbash {
    private Atbash() {
    }

    public static String cypher(String words) {
        var result = new ArrayList<Character>();
        for (char ch : words.toCharArray()) {
            if (!isLatinLetter(ch)) {
                result.add(ch);
                continue;
            }
            char begin;
            char end;
            if (Character.isUpperCase(ch)) {
                begin = 'A';
                end = 'Z';
            } else {
                begin = 'a';
                end = 'z';
            }

            int distance = ch - begin;
            int newChar = end - distance;

            result.add((char) newChar);
        }

        return getResultString(result);
    }

    private static boolean isLatinLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private static String getResultString(ArrayList<Character> characters) {
        var sb = new StringBuilder();
        for (char ch : characters) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
