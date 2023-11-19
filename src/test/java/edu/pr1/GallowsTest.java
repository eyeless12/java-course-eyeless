package edu.pr1;

import edu.pr1.results.GuessResult;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GallowsTest {
    @Test
    void TestRegisterCorrectly() {
        GallowsGameSession session = new GallowsGameSession(new TestWordGenerator(), 10);
        char[] expected = "A**a*a*a**a".toCharArray();
        GuessResult result = session.guess('A');
        assertThat(result.attempt()).isEqualTo(0);
        assertThat(result).isInstanceOf(GuessResult.SuccessfulGuess.class);
        assertThat(result.state()).containsSequence(expected);
    }

    @Test
    void TestDefeat() {
        GallowsGameSession session = new GallowsGameSession(new TestWordGenerator(), 10);
        GuessResult result = null;
        for (int i = 0; i < 10; i++) {
            result = session.guess('f');
            if (i != 9) {
                assertThat(result).isInstanceOf(GuessResult.FailedGuess.class);
            }
        }
        assertThat(result).isInstanceOf(GuessResult.Defeat.class);
    }

    @Test
    void TestWin() {
        GallowsGameSession session = new GallowsGameSession(new TestWordGenerator(), 10);
        char[] guesses = new char[] {'a', 'b', 'r', 'c', 'd'};
        GuessResult result = null;
        for (char ch : guesses) {
            result = session.guess(ch);
        }
        assertThat(result).isInstanceOf(GuessResult.Win.class);
    }
}
