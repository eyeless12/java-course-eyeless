package edu.pr1.runners;

import edu.pr1.GallowsGameSession;
import edu.pr1.results.GuessResult;
import edu.pr1.word_generators.RandomWordGenerator;
import java.util.Scanner;

public class GallowsConsoleRunner implements GallowsRunner {
    private final GallowsGameSession gameSession;
    public GallowsConsoleRunner() {
        gameSession = new GallowsGameSession(new RandomWordGenerator(), 10);
    }
    @Override
    public void run() {
        System.out.println("Welcome to the Gallows game!");
        Scanner sc = new Scanner(System.in);
        GuessResult result = null;
        while (!(result instanceof GuessResult.Defeat || result instanceof GuessResult.Win)) {
            printState();
            System.out.print("Your guess: ");
            String input = sc.next();
            if (input.length() > 1) {
                System.out.println("Wrong input!");
                continue;
            }
            char letter = input.charAt(0);
            result = guess(letter);
            System.out.println(result.message());
        }
    }

    @Override
    public void printState() {
        System.out.println(gameSession.getCurrentStateMessage());
    }

    @Override
    public GuessResult guess(char letter) {
        return gameSession.guess(letter);
    }
}
