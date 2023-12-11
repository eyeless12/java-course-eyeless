package edu.hw7;
import edu.hw7.task2.Factorial;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FactorialTests {
    @Test
    void testZeroF() {
        assertThat(Factorial.getFactorial(0)).isEqualTo(1);
    }

    @Test
    void test1F() {
        assertThat(Factorial.getFactorial(1)).isEqualTo(1);
    }

    @Test
    void test5F() {
        assertThat(Factorial.getFactorial(5)).isEqualTo(120);
    }

    @Test
    void test10F() {
        assertThat(Factorial.getFactorial(10)).isEqualTo(3628800);
    }
}
