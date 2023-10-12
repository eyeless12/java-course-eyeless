package edu.hw2.TaskFour;


public final class CallingHelper {
    private CallingHelper() {}

    public static CallingInfo callingInfo() {
        var stackTrace = Thread.currentThread().getStackTrace();
        var element = stackTrace[2];
        return new CallingInfo(element.getClassName(), element.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
