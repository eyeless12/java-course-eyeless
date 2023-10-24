package edu.pr1.runners;

import edu.pr1.GallowsGameSession;
import edu.pr1.results.GuessResult;
import edu.pr1.word_generators.RandomWordGenerator;
import java.util.Scanner;
import java.util.logging.Logger;

public class GallowsConsoleRunner implements GallowsRunner {
    private final GallowsGameSession gameSession;
    private static final int DEFAULT_GALLOWS_ATTEMPTS = 10;
    private static final Logger LOGGER = Logger.getLogger(GallowsConsoleRunner.class.getName());

    public GallowsConsoleRunner() {
        gameSession = new GallowsGameSession(new RandomWordGenerator(), DEFAULT_GALLOWS_ATTEMPTS);
    }

    @Override
    public void run() {
        LOGGER.info("Welcome to the Gallows game! Enter '/q' for exit");
        Scanner sc = new Scanner(System.in);
        GuessResult result = null;
        while (!(result instanceof GuessResult.Defeat || result instanceof GuessResult.Win)) {
            printState();
            LOGGER.info("Your guess: ");
            String input = sc.next();
            if (input.length() > 1) {
                if (input.equals("/q")) {
                    LOGGER.info("Defeat!");
                    break;
                }
                LOGGER.info("Wrong input!");
                continue;
            }
            char letter = input.charAt(0);
            result = guess(letter);
            LOGGER.info(result.message());
        }
    }

    @Override
    public void printState() {
        LOGGER.info(gameSession.getCurrentStateMessage());
    }

    @Override
    public GuessResult guess(char letter) {
        return gameSession.guess(letter);
    }

    public static void main(String[] args) {
        var runner = new GallowsConsoleRunner();
        runner.run();
    }
}
