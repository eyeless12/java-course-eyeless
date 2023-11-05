package edu.hw5.task3;

import edu.hw5.task3.parsers.DateParser;
import edu.hw5.task3.parsers.ParserEight;
import edu.hw5.task3.parsers.ParserFive;
import edu.hw5.task3.parsers.ParserFour;
import edu.hw5.task3.parsers.ParserOne;
import edu.hw5.task3.parsers.ParserSeven;
import edu.hw5.task3.parsers.ParserSix;
import edu.hw5.task3.parsers.ParserThree;
import edu.hw5.task3.parsers.ParserTwo;
import java.time.LocalDate;
import java.util.Optional;

public class MultiParser {

    private final static DateParser[] DATE_PARSERS = new DateParser[] {
            new ParserOne(),
            new ParserTwo(),
            new ParserThree(),
            new ParserFour(),
            new ParserFive(),
            new ParserSix(),
            new ParserSeven(),
            new ParserEight(),
    };

    private MultiParser() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        for (var parser : DATE_PARSERS) {
            var ans = parser.tryParse(string);
            if (ans.isPresent()) {
                return ans;
            }
        }

        return Optional.empty();
    }
}
