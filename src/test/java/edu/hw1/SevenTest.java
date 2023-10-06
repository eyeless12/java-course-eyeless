package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.hw1.TaskSeven.rotateRight;
import static edu.hw1.TaskSeven.rotateLeft;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class SevenTest {
    @Test
    @DisplayName("Налево 1 разряд")
    void leftOne(){
        assertThat(rotateLeft(9, 1)).isEqualTo(3);
    }

    @Test
    @DisplayName("Налево разрядов больше, чем длина")
    void shiftLeftGreaterThanBinLength(){
        // 1000101 -> 0010110
        assertThat(rotateLeft(69, 9)).isEqualTo(22);
    }

    @Test
    @DisplayName("Shift влево = length")
    void shiftEqualsLength(){
        // 110101 => 110101 1 4 16 32
        assertThat(rotateLeft(53, 6)).isEqualTo(53);
    }

    @Test
    @DisplayName("rotateLeft(0)")
    void shiftZero(){
        assertThat(rotateLeft(0, 5)).isEqualTo(0);
    }

    @Test
    @DisplayName("Направо 1 разряд")
    void rightOne(){
        assertThat(rotateRight(45, 1)).isEqualTo(54);
    }

    @Test
    @DisplayName("Направо разрядов больше, чем длина")
    void shiftRightGreaterThanBinLength(){
        // 1101 -> 1110
        assertThat(rotateRight(13, 5)).isEqualTo(14);
    }

    @Test
    @DisplayName("Exception на отрицательных аргументах")
    void exceptions(){
        assertThatThrownBy(() -> rotateRight(-2, -3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> rotateLeft(-2, -3)).isInstanceOf(IllegalArgumentException.class);
    }
}
