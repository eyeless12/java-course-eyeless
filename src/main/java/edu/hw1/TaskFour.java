package edu.hw1;

public class TaskFour {
    public static String fixString(String source){
        var stringBuilder = new StringBuilder();
        for (var i = 0; i < source.length() - 1; i += 2){
            stringBuilder.append(source.charAt(i + 1));
            stringBuilder.append(source.charAt(i));
        }
        return stringBuilder.toString();
    }
}
