package edu.hw1;

public final class TaskFive {
    private TaskFive() {
        throw new IllegalStateException();
    }

    public static boolean isPalindromeDescendant(String number) {
        String newNumber = number;
        while (newNumber.length() > 1) {
            if (isPalindrome(newNumber)) {
                return true;
            }
            newNumber = getChild(newNumber);
        }
        return false;
    }

    private static boolean isPalindrome(String number) {
        int numberStringLength = number.length();
        for (var i = 0; i < numberStringLength / 2; i++) {
            if (number.charAt(i) != number.charAt(numberStringLength - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String getChild(String number) {
        StringBuilder newNumberBuilder = new StringBuilder();
        int length = number.length();
        for (int i = 0; i < length - 1; i += 2) {
            int first = Character.getNumericValue(number.charAt(i));
            int second = Character.getNumericValue(number.charAt(i + 1));
            newNumberBuilder.append(first + second);
        }
        if (length % 2 != 0) {
            newNumberBuilder.append(Character.getNumericValue(number.charAt(length - 1)));
        }
        return newNumberBuilder.toString();
    }
}
