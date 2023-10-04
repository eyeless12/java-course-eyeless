package edu.hw1;

public class TaskFive {
    public static boolean isPalindromeDescendant(int number){
        if (String.valueOf(number).length() <= 1)
            return false;
        if (!isPalindrome(number)){
            return isPalindromeDescendant(getChild(number));
        }
        return true;
    }

    private static boolean isPalindrome(int number){
        var numberString = String.valueOf(number);
        var numberStringLength = numberString.length();
        for (var i = 0; i < numberStringLength / 2; i++){
            if (numberString.charAt(i) != numberString.charAt(numberStringLength - i - 1)){
                return false;
            }
        }
        return true;
    }

    private static int getChild(int number){
        var numberString = String.valueOf(number);
        var newNumberBuilder = new StringBuilder();
        for (var i = 0; i < numberString.length() - 1; i += 2){
            newNumberBuilder.append(Character.getNumericValue(numberString.charAt(i))
                + Character.getNumericValue(numberString.charAt(i + 1)));
        }
        return Integer.parseInt(newNumberBuilder.toString());
    }
}
