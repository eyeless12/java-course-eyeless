package edu.pr1.word_generators;

import java.util.Random;

public class RandomWordGenerator implements IWordGenerator {
    private final String[] words = {"Noski", "Pivo", "Tinkoff", "Hockey", "Tagil", "Klavesin", "Petya", "Korova"};
    private final Random random;

    public RandomWordGenerator() {
        this.random = new Random();
    }

    @Override
    public String getWord() {
        return words[random.nextInt(words.length)];
    }
}
