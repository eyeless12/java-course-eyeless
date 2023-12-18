package edu.hw8.threadPool;

@SuppressWarnings("all")
public class Tester {
    private static final int TEST_INT = 10;

    private Tester() { }

    public static Long[] testThreadPool() throws InterruptedException {
        var results = new Long[10];
        try (FixedThreadPool threadPool = new FixedThreadPool(4)) {
            threadPool.start();
            for (int i = TEST_INT; i < TEST_INT + 10; i++) {
                final int index = i;
                threadPool.execute(() -> {
                    long result = fibonacci(index);
                    results[index - TEST_INT] = result;
                });
            }
            Thread.sleep(1000);
        }
        return results;
    }

    public static Long[] testSynchrone() throws InterruptedException {
        var results = new Long[10];
            for (int i = TEST_INT; i < TEST_INT + 10; i++) {
                long result = fibonacci(i);
                results[i - TEST_INT] = result;
            }
        return results;
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

