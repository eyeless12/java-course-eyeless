package edu.hw3;

import edu.hw3.task4.RomeNums;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    void One() {
        var result = RomeNums.convertToRoman(1);
        assertThat(result).isEqualTo("I");
    }

    @Test
    void Fifteen() {
        var result = RomeNums.convertToRoman(15);
        assertThat(result).isEqualTo("XV");
    }

    @Test
    void DvestiOdin() {
        var result = RomeNums.convertToRoman(201);
        assertThat(result).isEqualTo("CCI");
    }

    @Test
    void DvaDvaVosem() {
        var result = RomeNums.convertToRoman(228);
        assertThat(result).isEqualTo("CCXXVIII");
    }

    @Test
    void OdinTriTriSem() {
        var result = RomeNums.convertToRoman(1337);
        assertThat(result).isEqualTo("MCCCXXXVII");
    }

    @Test
    void Zero() {
        var result = RomeNums.convertToRoman(0);
        assertThat(result).isEqualTo("");
    }
}