package edu.pr1.results;

import org.jetbrains.annotations.NotNull;

sealed public interface GuessResult {
    char[] state();
    int attempt();
    int maxAttempts();

    String message();

    record Defeat(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public char[] state() {
            return state;
        }

        @Override
        public int attempt() {
            return attempt;
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public String message() {
            return "You lost!";
        }
    }
    record Win(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public char[] state() {
            return state;
        }

        @Override
        public int attempt() {
            return attempt;
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public String message() {
            return "You win!";
        }
    }
    record SuccessfulGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public char[] state() {
            return state;
        }

        @Override
        public int attempt() {
            return attempt;
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public String message() {
            return "Hit!";
        }
    }
    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public char[] state() {
            return state;
        }

        @Override
        public int attempt() {
            return attempt;
        }

        @Override
        public int maxAttempts() {
            return maxAttempts;
        }

        @Override
        public String message() {
            return String.format("Missed, mistake %d out of %d", attempt, maxAttempts);
        }
    }
}
