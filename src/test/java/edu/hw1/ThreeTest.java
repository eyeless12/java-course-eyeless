package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.TaskThree.isArraysCanBeNested;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class ThreeTest {
    @Test
    @DisplayName("Стандартное пересечение 1")
    void testBasic1(){
        int[] a = {1, 2, 3, 4};
        int[] b = {0, 6};
        assertThat(isArraysCanBeNested(a, b)).isEqualTo(true);
    }

    @Test
    @DisplayName("Стандартное пересечение 2")
    void testBasic2(){
        int[] a = {3, 1};
        int[] b = {4, 0};
        assertThat(isArraysCanBeNested(a, b)).isEqualTo(true);
    }

    @Test
    @DisplayName("Массивы из одного элемента")
    void testOneElement(){
        int[] a = {5};
        int[] b = {5};
        assertThat(isArraysCanBeNested(a, b)).isEqualTo(false);
    }

    @Test
    @DisplayName("Пустой массив")
    void testEmptyArrray(){
        int[] a = {};
        int[] b = {5, 4, 1, 3};
        assertThatThrownBy(() -> isArraysCanBeNested(a, b)).isInstanceOf(IllegalArgumentException.class);
    }
}
