package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class TaskFour {
    private TaskFour(){
        throw new IllegalStateException();
    }
    public static String fixString(@NotNull String source) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = source.length();
        for (var i = 0; i < length - 1; i += 2) {
            stringBuilder.append(source.charAt(i + 1));
            stringBuilder.append(source.charAt(i));
        }
        if (length % 2 != 0) {
            stringBuilder.append(source.charAt(length - 1));
        }
        return stringBuilder.toString();
    }
}
