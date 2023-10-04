package edu.hw1;

import static edu.hw1.TaskOne.getVideoLengthInSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OneTest {
    @Test
    @DisplayName("Меньше 60 минут")
    void testMinutesLessSixty(){
        String input = "42:42";
        assertThat(getVideoLengthInSeconds(input)).isEqualTo(2562);
    }

    @Test
    @DisplayName("Больше 60 минут")
    void testMinutesGreaterThanSixty(){
        String input = "420:42";
        assertThat(getVideoLengthInSeconds(input)).isEqualTo(25242);
    }

    @Test
    @DisplayName("Секунд больше 60")
    void testSecondsGreaterThanSixty(){
        String input = "420:61";
        assertThat(getVideoLengthInSeconds(input)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Секунд меньше 0")
    void testSecondsLessThanZero(){
        String input = "420:-5";
        assertThat(getVideoLengthInSeconds(input)).isEqualTo(-1);
    }
}
