package edu.pr1.runners;

import edu.pr1.GallowsGameSession;
import edu.pr1.results.GuessResult;
import edu.pr1.word_generators.RandomWordGenerator;
import java.util.Scanner;
import java.util.logging.Logger;

public class GallowsConsoleRunner implements GallowsRunner {
    private final GallowsGameSession gameSession;
    private static final int DEFAULT_GALLOWS_ATTEMPTS = 10;
    private static Logger logger = Logger.getLogger(GallowsConsoleRunner.class.getName());

    public GallowsConsoleRunner() {
        gameSession = new GallowsGameSession(new RandomWordGenerator(), DEFAULT_GALLOWS_ATTEMPTS);
    }

    @Override
    public void run() {
        logger.info("Welcome to the Gallows game!");
        Scanner sc = new Scanner(System.in);
        GuessResult result = null;
        while (!(result instanceof GuessResult.Defeat || result instanceof GuessResult.Win)) {
            printState();
            logger.info("Your guess: ");
            String input = sc.next();
            if (input.length() > 1) {
                logger.info("Wrong input!");
                continue;
            }
            char letter = input.charAt(0);
            result = guess(letter);
            logger.info(result.message());
        }
    }

    @Override
    public void printState() {
        logger.info(gameSession.getCurrentStateMessage());
    }

    @Override
    public GuessResult guess(char letter) {
        return gameSession.guess(letter);
    }
}
