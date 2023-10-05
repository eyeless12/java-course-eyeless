package edu.hw1;

public final class TaskTwo {
    private static final int TEN_RADIX = 10;

    private TaskTwo() {
        throw new IllegalStateException();
    }

    public static int countDigits(int n) {
        int digitsCount = 0;
        int remains = n;
        do {
            remains /= TEN_RADIX;
            digitsCount++;
        }
        while (remains != 0);
        return digitsCount;
    }
}
