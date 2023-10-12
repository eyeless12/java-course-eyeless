package edu.hw2;

import edu.hw2.TaskTwo.Rectangle;
import edu.hw2.TaskTwo.Square;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TaskTwoTest {
    static Arguments[] rectangles() {
        return new Arguments[]{
                Arguments.of(new Rectangle(10, 20), 200),
                Arguments.of(new Square(10), 100)
        };
    }

    //Сделал классы immutable. Что тут тестировать?)
    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect, int area) {
        assertThat(rect.area()).isEqualTo(area);
    }

    @Test
    void NegateWidthHeightThrowsException() {
        assertThatThrownBy(() -> new Square(-5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Rectangle(-3, -2)).isInstanceOf(IllegalArgumentException.class);
    }
}
