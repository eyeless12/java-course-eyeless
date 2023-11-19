package edu.hw7;

import org.junit.jupiter.api.Test;
import edu.hw7.task1.AtomicCounter;
import static org.assertj.core.api.Assertions.assertThat;

public class CounterTests {
    @Test
    void testTwoThreadsIncrementing() throws InterruptedException{
        var counter = new AtomicCounter();
        var thread1 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread2 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(counter.getCounter()).isEqualTo(20);
    }

    @Test
    void testFourThreadsIncrementing() throws InterruptedException{
        var counter = new AtomicCounter();
        var thread1 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread2 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread3 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread4 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        assertThat(counter.getCounter()).isEqualTo(40);
    }

    @Test
    void test8Threads() throws InterruptedException {
        var counter = new AtomicCounter();
        var thread1 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread2 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread3 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread4 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread5 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread6 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread7 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        var thread8 = new Thread(() -> {
            for (var i = 0; i < 10; i++){
                counter.Increment();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();

        assertThat(counter.getCounter()).isEqualTo(80);
    }
}
