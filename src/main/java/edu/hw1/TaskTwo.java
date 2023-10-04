package edu.hw1;

public class TaskTwo {
    public static int countDigits(int n){

        var digitsCount = 0;
        do {
            n /= 10;
            digitsCount++;
        }
        while (n != 0);
        return digitsCount;
    }
}
