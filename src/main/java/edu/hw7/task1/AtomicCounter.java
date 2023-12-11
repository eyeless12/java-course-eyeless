package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.getAndIncrement();
    }

    public int getCounter() {
        return counter.get();
    }
}
