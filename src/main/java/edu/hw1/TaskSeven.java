package edu.hw1;

public class TaskSeven {
    public static int rotateLeft(int n, int shift) throws IllegalArgumentException {
        if (n < 0 || shift < 0) {
            throw new IllegalArgumentException();
        }
        char[] nBinary = Integer.toBinaryString(n).toCharArray();
        int arrayLength = nBinary.length;
        char[] result = new char[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int indexToMove = (i - shift) % arrayLength;
            if (indexToMove < 0) {
                indexToMove += arrayLength;
            }
            result[indexToMove] = nBinary[i];
        }
        return Integer.parseInt(String.valueOf(result), 2);
    }

    public static int rotateRight(int n, int shift) throws IllegalArgumentException {
        if (n < 0 || shift < 0) {
            throw new IllegalArgumentException();
        }
        char[] nBinary = Integer.toBinaryString(n).toCharArray();
        int arrayLength = nBinary.length;
        char[] result = new char[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int indexToMove = (i + shift) % arrayLength;
            result[indexToMove] = nBinary[i];
        }
        return Integer.parseInt(String.valueOf(result), 2);
    }
}
