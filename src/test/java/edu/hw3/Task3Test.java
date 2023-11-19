package edu.hw3;
import edu.hw3.task3.WordFrequency;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class Task3Test {
    @Test
    void Nums() {
        var values = Arrays.asList(3, 4, 1, 2, 6, 3, 2, 1, 1, 1, 5);
        var result = WordFrequency.getFreqDict(values);
        assertThat(result.get(1)).isEqualTo(4);
        assertThat(result.get(2)).isEqualTo(2);
        assertThat(result.get(3)).isEqualTo(2);
        assertThat(result.get(4)).isEqualTo(1);
    }

    @Test
    void Strings() {
        var values = Arrays.asList("gena", "petya", "vasya", "dima", "petya", "noski", "petya", "klavesin", "football");
        var result = WordFrequency.getFreqDict(values);
        assertThat(result.get("gena")).isEqualTo(1);
        assertThat(result.get("petya")).isEqualTo(3);
        assertThat(result.get("klavesin")).isEqualTo(1);
    }

    @Test
    void Empty() {
        var values = List.of();
        var result = WordFrequency.getFreqDict(values);
        assertThat(result.isEmpty()).isEqualTo(true);
    }
}
