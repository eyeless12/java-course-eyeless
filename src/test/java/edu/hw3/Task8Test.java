package edu.hw3;
import edu.hw3.task8.BackwardIterator;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Task8Test {
    @Test
    void SimpleInts() {
        var values = List.of(1, 5, 7, 3, 1, 3);
        var backwardIterator = new BackwardIterator<>(values);
        for (int n : values.reversed()) {
            assertThat(backwardIterator.next()).isEqualTo(n);
        }
    }

    @Test
    void SimpleStrings() {
        var values = List.of("gena", "petya", "vasya", "dima", "petya", "noski", "petya", "klavesin", "football");
        var backwardIterator = new BackwardIterator<>(values);
        for (String s : values.reversed()) {
            assertThat(backwardIterator.next()).isEqualTo(s);
        }
    }
}
