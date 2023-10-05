package edu.hw1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class TaskSix {
    public static final int CAPRECARS_NUMBER = 6174;
    public static final int LEFT_BORDER = 1000;
    public static final int RIGHT_BORDER = 9999;

    private TaskSix() {
        throw new IllegalStateException();
    }

    private static int getCaprecarsConversionCount(int n, int attempts) {
        if (n == CAPRECARS_NUMBER) {
            return attempts;
        }
        return getCaprecarsConversionCount(caprecarsMinus(n), attempts + 1);
    }

    public static int getCaprecarsConversionCount(int n) throws IllegalArgumentException {
        char[] nCharArray = String.valueOf(n).toCharArray();
        Set<Character> nSet = new HashSet<Character>();
        for (char i : nCharArray) {
            nSet.add(i);
        }
        if (n < LEFT_BORDER || n > RIGHT_BORDER || nSet.size() == 1) {
            throw new IllegalArgumentException();
        }
        return getCaprecarsConversionCount(n, 0);
    }

    private static int caprecarsMinus(int n) {
        char[] digits = sortDigits(n);
        int nSortedAscending = Integer.parseInt(new String(digits));
        reverseArray(digits);
        int nSortedDescending = Integer.parseInt(new String(digits));
        return nSortedDescending - nSortedAscending;
    }

    private static char @NotNull [] sortDigits(int n) {
        String numberStr = Integer.toString(n);
        char[] digits = numberStr.toCharArray();
        Arrays.sort(digits);
        return digits;
    }

    private static void reverseArray(char @NotNull [] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
