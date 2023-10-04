package edu.hw1;

public class TaskTwo {
    private TaskTwo(){
        throw new IllegalStateException();
    }
    public static int countDigits(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int digitsCount = 0;
        do {
            n /= 10;
            digitsCount++;
        }
        while (n != 0);
        return digitsCount;
    }
}
