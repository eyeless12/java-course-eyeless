package edu.hw7;
import edu.hw7.task4.PiCounter;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class PiTests {
    @Test
    void testPiIsRight() {
        var counter = new PiCounter();
        var points = Arrays.asList(1000000, 10000000, 100000000);
        for (var point : points) {
            var piOneThread = counter.countPi(point);
            var piMultiThread = counter.countPiParallel(point);

            assertThat(piOneThread).isCloseTo(Math.PI, Offset.offset(0.01d));
            assertThat(piMultiThread).isCloseTo(Math.PI, Offset.offset(0.01d));
        }
    }

    @Test
    void testMultiThreadIsFaster() {
        var counter = new PiCounter();
        var points = Arrays.asList(10000000, 100000000);
        for (var point : points) {
            var startTimeOne = System.currentTimeMillis();
             counter.countPi(point);
            var endTimeOne = System.currentTimeMillis();

            var startTimeMulti = System.currentTimeMillis();
            counter.countPiParallel(point);
            var endTimeMulti = System.currentTimeMillis();

            assertThat(endTimeOne - startTimeOne).isGreaterThan(endTimeMulti - startTimeMulti);
        }
    }
}
