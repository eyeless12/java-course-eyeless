package edu.hw1;

public final class TaskFive {
    private TaskFive() {
        throw new IllegalStateException();
    }

    public static boolean isPalindromeDescendant(int number) {
        int newNumber = number;
        while (String.valueOf(newNumber).length() > 1) {
            if (isPalindrome(newNumber)) {
                return true;
            }
            newNumber = getChild(newNumber);
        }
        return false;
    }

    private static boolean isPalindrome(int number) {
        String numberString = String.valueOf(number);
        int numberStringLength = numberString.length();
        for (var i = 0; i < numberStringLength / 2; i++) {
            if (numberString.charAt(i) != numberString.charAt(numberStringLength - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int getChild(int number) {
        String numberString = String.valueOf(number);
        StringBuilder newNumberBuilder = new StringBuilder();
        int length = numberString.length();
        for (int i = 0; i < length - 1; i += 2) {
            newNumberBuilder.append(Character.getNumericValue(numberString.charAt(i))
                    + Character.getNumericValue(numberString.charAt(i + 1)));
        }
        if (length % 2 != 0) {
            newNumberBuilder.append(Character.getNumericValue(numberString.charAt(length - 1)));
        }
        return Integer.parseInt(newNumberBuilder.toString());
    }
}
