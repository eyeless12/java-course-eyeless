package edu.hw1;

import java.util.logging.Logger;

public final class TaskZero {
    private TaskZero() {
        throw new IllegalStateException();
    }

    public static void printHelloWorld() {
        var logger = Logger.getLogger(TaskZero.class.getName());
        logger.info("Привет, мир!");
    }
}
