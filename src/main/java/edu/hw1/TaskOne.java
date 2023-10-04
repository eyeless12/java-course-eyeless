package edu.hw1;

import java.util.Arrays;

public class TaskOne {
    public static int getVideoLengthInSeconds(String timecode){
        var tokens = Arrays.stream(timecode.split(":")).mapToInt(Integer::valueOf).toArray();
        var minutes = tokens[0];
        var seconds = tokens[1];
        return seconds < 0 || seconds > 60 ? -1 : minutes * 60 + seconds;
    }
}
