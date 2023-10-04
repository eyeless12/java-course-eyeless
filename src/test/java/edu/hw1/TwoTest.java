package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static edu.hw1.TaskTwo.countDigits;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TwoTest {
    @Test
    @DisplayName("Рандомный тест")
    void testRandom(){
        int rand = new Random().nextInt(1000000);
        assertThat(countDigits(rand)).isEqualTo(String.valueOf(rand).toCharArray().length);
    }

    @Test
    @DisplayName("Тест нуля")
    void testOneDigit(){
        assertThat(countDigits(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("Исключение при отрицательном аргументе")
    void testException(){

        assertThatThrownBy(() -> countDigits(-5)).isInstanceOf(IllegalArgumentException.class);
    }
}
