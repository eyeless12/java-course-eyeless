package edu.hw2.Task4;


public final class CallingHelper {
    private CallingHelper() {
    }

    public static CallingInfo callingInfo() {
        String className;
        String methodName;
        var previousContext = new Throwable().getStackTrace()[1];

        return new CallingInfo(previousContext.getClassName(), previousContext.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
