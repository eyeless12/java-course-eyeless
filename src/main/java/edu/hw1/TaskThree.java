package edu.hw1;

public class TaskThree {
    public static boolean isArraysCanBeNested(int[] first, int[] second) {
        var firstMin = Integer.MAX_VALUE;
        var secondMin = Integer.MAX_VALUE;
        var firstMax = Integer.MIN_VALUE;
        var secondMax = Integer.MIN_VALUE;
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
