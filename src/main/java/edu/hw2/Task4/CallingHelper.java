package edu.hw2.Task4;


public final class CallingHelper {
    private CallingHelper() {
    }

    public static CallingInfo callingInfo() {
        String className;
        String methodName;
        try {
            //Хоть и в задании было так, но колхоз какой то....
            throw new Exception();
        } catch (Exception e) {
            var previousContext = e.getStackTrace()[1];
            className = previousContext.getClassName();
            methodName = previousContext.getMethodName();
        }

        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {
    }
}
