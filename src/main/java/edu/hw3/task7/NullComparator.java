package edu.hw3.task7;

import java.util.Comparator;

public class NullComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1 == null && s2 != null) {
            return -1;
        }
        if (s1 == null) {
            return 0;
        }
        return s1.compareTo(s2);
    }
}
