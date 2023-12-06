package edu.hw5.task7;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RegexesTests {

    @Test
    public void testFirst() {
        var s1 = "010";
        var s2 = "0101110001";
        var s3 = "010000";

        assertThat(Regexes.findOne(s1)).isTrue();
        assertThat(Regexes.findOne(s2)).isTrue();
        assertThat(Regexes.findOne(s3)).isTrue();
    }

    @Test
    public void testSecond() {
        var s1 = "010";
        var s2 = "1101110001";

        assertThat(Regexes.findTwo(s1)).isTrue();
        assertThat(Regexes.findTwo(s2)).isTrue();
    }

    @Test
    public void testThird() {
        var s1 = "010";
        var s2 = "1101110001";
        var s3 = "11";
        var s4 = "1";

        assertThat(Regexes.findThree(s1)).isTrue();
        assertThat(Regexes.findThree(s2)).isFalse();
        assertThat(Regexes.findThree(s3)).isTrue();
        assertThat(Regexes.findThree(s4)).isTrue();
    }
}
