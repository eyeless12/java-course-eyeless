package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.TaskFive.isPalindromeDescendant;
import static org.assertj.core.api.Assertions.assertThat;

public class FiveTest {
    @Test
    @DisplayName("Обычный тест")
    void testStandart(){
        assertThat(isPalindromeDescendant(11211230)).isEqualTo(true);
    }

    @Test
    @DisplayName("Тест false")
    void testNotPalindrome(){
        assertThat(isPalindromeDescendant(2152)).isEqualTo(false);
    }

    @Test
    @DisplayName("Нечетное количество цифр")
    void testNotEvenFalse(){
        assertThat(isPalindromeDescendant(1121123)).isEqualTo(true);
    }

    @Test
    @DisplayName("Нечетное количество цифр не проходит")
    void testNotEvenTrue(){
        assertThat(isPalindromeDescendant(427)).isEqualTo(false);
    }

    @Test
    @DisplayName("Сумма цифр больше девяти")
    void testGreaterThanNine(){
        assertThat(isPalindromeDescendant(3288)).isEqualTo(true);
    }
}
