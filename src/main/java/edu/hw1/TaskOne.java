package edu.hw1;


public final class TaskOne {
    private static final int SECONDS_IN_MINUTE = 60;

    private TaskOne() {
        throw new IllegalStateException();
    }

    public static int getVideoLengthInSeconds(String timecode) {
        String[] tokens = timecode.split(":");
        Integer minutes = tryParse(tokens[0]);
        Integer seconds = tryParse(tokens[1]);
        return minutes == null || seconds == null
                || seconds < 0 || seconds >= SECONDS_IN_MINUTE || minutes < 0 ? -1
                : minutes * SECONDS_IN_MINUTE + seconds;
    }

    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
