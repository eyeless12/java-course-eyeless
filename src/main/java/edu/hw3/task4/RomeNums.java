package edu.hw3.task4;

public class RomeNums {
    private static final RomanNumber[] ROMAN_NUMBERS =
            {
                    new RomanNumber(1000, "M"),
                    new RomanNumber(900, "CM"),
                    new RomanNumber(500, "D"),
                    new RomanNumber(400, "CD"),
                    new RomanNumber(100, "C"),
                    new RomanNumber(90, "XC"),
                    new RomanNumber(50, "L"),
                    new RomanNumber(40, "XL"),
                    new RomanNumber(10, "X"),
                    new RomanNumber(9, "IX"),
                    new RomanNumber(5, "V"),
                    new RomanNumber(4, "IV"),
                    new RomanNumber(1, "I")
            };

    private RomeNums() {
    }

    public static String convertToRoman(int num) {
        int numRemains = num;
        StringBuilder roman = new StringBuilder();
        for (RomanNumber n : ROMAN_NUMBERS) {
            while (numRemains >= n.value) {
                numRemains -= n.value;
                roman.append(n.roman);
            }
        }
        return roman.toString();
    }

    record RomanNumber(int value, String roman) {
    }
}

