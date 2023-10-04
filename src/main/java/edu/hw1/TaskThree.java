package edu.hw1;

public class TaskThree {
    public static boolean isArraysCanBeNested(int[] first, int[] second) throws IllegalArgumentException {
        if (first.length == 0 || second.length == 0) {
            throw new IllegalArgumentException();
        }
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int j : first) {
            firstMin = Math.min(j, firstMin);
            firstMax = Math.max(j, firstMax);
        }
        for (int j : second) {
            secondMin = Math.min(j, secondMin);
            secondMax = Math.max(j, secondMax);
        }
        return firstMin > secondMin && firstMax < secondMax;
    }
}
