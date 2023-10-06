package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.TaskFour.fixString;
import static org.assertj.core.api.Assertions.assertThat;

public class FourTest {
    @Test
    @DisplayName("Стандартная строка")
    void testStandart(){
        String a = "hTsii  s aimex dpus rtni.g";
        assertThat(fixString(a)).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Пустая строка")
    void testEmpty(){
        assertThat(fixString("")).isEqualTo("");
    }

    @Test
    @DisplayName("Строка с нечетным количеством символов")
    void testNotEven(){
        assertThat(fixString("12345")).isEqualTo("21435");
    }
}
