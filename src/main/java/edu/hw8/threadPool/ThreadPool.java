package edu.hw8.threadPool;

public interface ThreadPool extends AutoCloseable {
    void start();

    void execute(Runnable runnable);
}
