package edu.hw5.task3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

public class ParserTests {
    @Test
    public void testParserOne() {
        var date = "2020-10-10";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.of(2020, 10, 10));
    }

    @Test
    public void testParserTwo() {
        var date = "2020-12-2";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.of(2020, 12, 2));
    }

    @Test
    public void testParserThree() {
        var date = "1/3/1976";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.of(1976, 3, 1));
    }

    @Test
    public void testParserFour() {
        var date = "1/3/20";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.of(2020, 3, 1));
    }

    @Test
    public void testParserFive() {
        var date = "tomorrow";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.now().plusDays(1));
    }

    @Test
    public void testParserSix() {
        var date = "today";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.now());
    }

    @Test
    public void testParserSeven() {
        var date = "yesterday";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.now().minusDays(1));
    }

    @Test
    public void testParserEight() {
        var date = "1 day ago";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.now().minusDays(1));

        date = "5 days ago";
        assertThat(MultiParser.parseDate(date).orElse(null)).isEqualTo(LocalDate.now().minusDays(5));
    }
}
