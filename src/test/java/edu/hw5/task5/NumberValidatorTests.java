package edu.hw5.task5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberValidatorTests {
    @Test
    public void testInvalidNumbers() {
        var s1 = "123АВЕ777";
        var s2 = "А123ВГ77";
        var s3 = "А123ВЕ7777";

        assertThat(NumberValidator.validate(s1)).isEqualTo(false);
        assertThat(NumberValidator.validate(s2)).isEqualTo(false);
        assertThat(NumberValidator.validate(s3)).isEqualTo(false);
    }

    @Test
    public void testValidNumbers() {
        var s1 = "О146НЕ174";
        var s2 = "А123ВЕ777";
        var s3 = "О777ОО177";

        assertThat(NumberValidator.validate(s1)).isEqualTo(true);
        assertThat(NumberValidator.validate(s2)).isEqualTo(true);
        assertThat(NumberValidator.validate(s3)).isEqualTo(true);
    }
}
