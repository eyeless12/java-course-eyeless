package edu.hw5.task1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class DurationTests {

    @Test
    public void testParsing() {
        var s1 = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        var s2 = "2022-04-01, 21:30 - 2022-04-02, 01:20";

        var result1 = DurationParser.getDuration(s1);
        assertThat(result1).isEqualTo("3ч 30м");

        var result2 = DurationParser.getDuration(s2);
        assertThat(result2).isEqualTo("3ч 50м");
    }

    @Test
    public void testEqualDuration() {
        var s = "2022-03-12, 20:20 - 2022-03-12, 20:20";
        var result = DurationParser.getDuration(s);
        assertThat(result).isEqualTo("0ч 0м");
    }
}
