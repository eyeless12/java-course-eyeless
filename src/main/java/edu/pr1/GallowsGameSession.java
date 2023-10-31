package edu.pr1;

import edu.pr1.results.GuessResult;
import edu.pr1.word_generators.IWordGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;

public class GallowsGameSession {
    private final String hiddenWord;
    private final char[] userGuess;
    private final HashSet<Character> guessed;
    private final int maxAttempts;
    private int attempts = 0;

    public GallowsGameSession(@NotNull IWordGenerator wordGenerator, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.hiddenWord = wordGenerator.getWord();
        this.userGuess = new char[hiddenWord.length()];
        Arrays.fill(userGuess, '*');
        guessed = new HashSet<>();
    }

    public GuessResult guess(char letterIn) {
        char letter = Character.toLowerCase(letterIn);
        if (!guessed.contains(letter)) {
            guessed.add(letter);
            Integer[] occurences = getLetterOccurences(letter);
            if (occurences.length != 0) {
                for (int i : occurences) {
                    userGuess[i] = hiddenWord.charAt(i);
                }
                if (isStarsRemain()) {
                    return new GuessResult.SuccessfulGuess(userGuess, attempts, maxAttempts);
                }
                return new GuessResult.Win(userGuess, attempts, maxAttempts);
            }
        }
        if (attempts < maxAttempts - 1) {
            attempts++;
            return new GuessResult.FailedGuess(userGuess, attempts, maxAttempts);
        }
        return new GuessResult.Defeat(userGuess, attempts, maxAttempts);
    }

    public String getCurrentStateMessage() {
        String state = String.valueOf(userGuess);
        return String.format("The word: %s", state);
    }

    private Integer @NotNull [] getLetterOccurences(char letter) {
        ArrayList<Integer> occurences = new ArrayList<>();
        for (int i = 0; i < hiddenWord.length(); i++) {
            char wordLetter = hiddenWord.charAt(i);
            if (Character.toLowerCase(wordLetter) == letter) {
                occurences.add(i);
            }
        }

        return occurences.toArray(new Integer[0]);
    }

    private boolean isStarsRemain() {
        for (char ch : userGuess) {
            if (ch == '*') {
                return true;
            }
        }
        return false;
    }
}
