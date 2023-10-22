package edu.hw3.task3;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;

public class WordFrequency {
    private WordFrequency() {
    }

    public static <T> Dictionary<T, Integer> getFreqDict(Collection<T> values) {
        var result = new Hashtable<T, Integer>();

        for (T s : values) {
            if (!result.containsKey(s)) {
                result.put(s, 1);
            } else {
                int oldCount = result.get(s);
                result.replace(s, oldCount + 1);
            }
        }

        return result;
    }
}
