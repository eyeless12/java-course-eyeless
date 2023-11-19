package edu.hw3.task2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Clusterizator {
    private Clusterizator() {
    }

    public static ArrayList<String> clusterize(@NotNull String braces) {
        var result = new ArrayList<String>();
        var bracesStack = new ArrayDeque<Character>();
        int openCount = 0;
        int closeCount = 0;
        for (char ch : braces.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                closeCount++;
            } else {
                throw new IllegalArgumentException();
            }
            bracesStack.add(ch);

            if (openCount == closeCount) {
                result.add(getCluster(bracesStack));
                openCount = 0;
                closeCount = 0;
            }
        }

        return result;
    }

    private static String getCluster(ArrayDeque<Character> braces) {
        var sb = new StringBuilder();
        while (!braces.isEmpty()) {
            sb.append(braces.removeFirst());
        }
        return sb.toString();
    }
}
