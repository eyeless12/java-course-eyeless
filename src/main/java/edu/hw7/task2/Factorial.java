package edu.hw7.task2;

import java.util.ArrayList;

public class Factorial {
    private Factorial() { }

    public static long getFactorial(long n) {
        if (n == 0) {
            return 1L;
        }
        var numbers = fillArrayWithNums(n);

        return numbers.parallelStream().reduce(1L, (l, r) -> l * r);
    }

    private static ArrayList<Long> fillArrayWithNums(long n) {
        var result = new ArrayList<Long>();
        for (long i = 1; i <= n; i++) {
            result.add(i);
        }
        return result;
    }
}
