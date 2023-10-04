package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.hw1.TaskSix.getCaprecarsConversionCount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SixTest {
    @Test
    @DisplayName("Тест на 1 преобразование")
    void testOneTransition(){
        assertThat(getCaprecarsConversionCount(3579)).isEqualTo(1);
    }

    @Test
    @DisplayName("Тест на 3 преобразования")
    void testThreeTransitions(){
        assertThat(getCaprecarsConversionCount(1234)).isEqualTo(3);
    }

    @Test
    @DisplayName("Тест на 7 преобразований")
    void testFiveTransitions(){
        assertThat(getCaprecarsConversionCount(5200)).isEqualTo(7);
    }

    @Test
    @DisplayName("Тест на 0 преобразований")
    void testZeroTransitions(){
        assertThat(getCaprecarsConversionCount(6174)).isEqualTo(0);
    }

    @Test
    @DisplayName("Исключение")
    void testExceptions(){
        assertThatThrownBy(() -> getCaprecarsConversionCount(5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> getCaprecarsConversionCount(12345)).isInstanceOf(IllegalArgumentException.class);
    }
}
