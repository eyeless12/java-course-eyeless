package edu.hw1;

import java.util.Arrays;

public final class TaskOne {
    private static final int secondsInMinute = 60;

    private TaskOne() {
        throw new IllegalStateException();
    }

    public static int getVideoLengthInSeconds(String timecode) {
        int[] tokens = Arrays.stream(timecode.split(":")).mapToInt(Integer::valueOf).toArray();
        int minutes = tokens[0];
        int seconds = tokens[1];
        return seconds < 0 || seconds > secondsInMinute ? -1 : minutes * secondsInMinute + seconds;
    }
}
