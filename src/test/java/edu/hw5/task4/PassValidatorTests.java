package edu.hw5.task4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class PassValidatorTests {
    @Test
    public void passwordContainsOneOfSymbols() {
        var symbols = new char [] {'~', '!', '@', '#', '$', '%', '^', '&', '*', '|'};
        var random = new Random();

        for (var sym : symbols) {
            var strongPasswordBuilder = new StringBuilder("A51245BC2314DE523FGHJK512341241LM131ON125PQRSTU12341YW3121421XYZ");
            strongPasswordBuilder.insert(random.nextInt(strongPasswordBuilder.length()), sym);

            assertThat(PasswordValidator.validate(strongPasswordBuilder.toString())).isEqualTo(true);
        }
    }
}
