package edu.hw1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class TaskSix {
    private TaskSix() {
        throw new IllegalStateException();
    }

    private static int getCaprecarsConversionCount(int n, int attempts) {
        if (n == 6174) {
            return attempts;
        }
        return getCaprecarsConversionCount(caprecarsMinus(n), ++attempts);
    }

    public static int getCaprecarsConversionCount(int n) throws IllegalArgumentException {
        if (n < 1000 || n > 9999) {
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
