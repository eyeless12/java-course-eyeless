package edu.pr1.runners;

import edu.pr1.results.GuessResult;

public interface GallowsRunner {
    void run();
    void printState();
    GuessResult guess(char letter);
}
