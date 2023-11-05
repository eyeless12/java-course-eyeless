package edu.hw5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UnluckyFridays {
    private static final int THIRTEEN = 13;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final int MONTHS_IN_YEAR = 12;

    private UnluckyFridays() { }

    public static String[] getAllUnluckyFridays(int year) {
        var ans = new ArrayList<String>();
        for (int month = 1; month <= MONTHS_IN_YEAR; month++) {
            var fridayDate = LocalDate.of(year, month, THIRTEEN);
            if (fridayDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                ans.add(fridayDate.format(FORMATTER));
            }
        }
        return ans.toArray(new String[0]);
    }

    public static String getClosestUnluckyFriday(String date) {
        var dateParsed = LocalDate.parse(date, FORMATTER);
        var unluckyFridays = getAllUnluckyFridays(dateParsed.getYear());

        for (var fridayDate : unluckyFridays) {
            var fridayDateParsed = LocalDate.parse(fridayDate, FORMATTER);
            if (fridayDateParsed.isAfter(dateParsed)) {
                return fridayDateParsed.format(FORMATTER);
            }
        }

        return null;
    }
}
