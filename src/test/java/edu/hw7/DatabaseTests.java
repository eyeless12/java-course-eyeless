package edu.hw7;
import edu.hw7.task3.LocalPersonDatabase;
import edu.hw7.task3.Person;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class DatabaseTests {
    @Test
    void testAddDelete() throws InterruptedException {
        var database = new LocalPersonDatabase();
        var thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                var person = new Person(i, "A", "A", "A");
                database.add(person);
            }
        });
        var thread2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                var person = new Person(i, "A", "A", "A");
                database.add(person);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(database.getDatabaseLength()).isEqualTo(20);

        thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                database.delete(i);
            }
        });
        thread2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                database.delete(i);
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(database.getDatabaseLength()).isEqualTo(0);
    }

    @Test
    void testFind() throws InterruptedException {
        var database = new LocalPersonDatabase();
        var thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                var iString = String.valueOf(i);
                var person = new Person(i, iString, iString, iString);
                database.add(person);
            }
        });
        var thread2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                var iString = String.valueOf(i);
                var person = new Person(i, iString, iString, iString);
                database.add(person);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        var thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                var iString = String.valueOf(i);
                var person1 = database.findByAddress(iString);
                var person2 = database.findByName(iString);
                var person3 = database.findByPhone(iString);

                assertThat(person1).isEqualTo(person2);
                assertThat(person2).isEqualTo(person3);
            }
        });

        var thread4 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                var iString = String.valueOf(i);
                var person1 = database.findByAddress(iString);
                var person2 = database.findByName(iString);
                var person3 = database.findByPhone(iString);

                assertThat(person1).isEqualTo(person2);
                assertThat(person2).isEqualTo(person3);
            }
        });

        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
    }
}
