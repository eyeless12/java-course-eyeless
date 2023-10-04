package edu.hw1;

public final class TaskEight {
    private static final int[][] POSSIBLE_DIRECTIONS = {
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2},
            {1, 2},
            {1, -2},
            {2, -1},
            {2, 1}
    };

    private TaskEight() {
        throw new IllegalStateException();
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (isHorseCapturingSomebody(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isHorseCapturingSomebody(int i, int j, int[][] board) {
        for (int[] direction : POSSIBLE_DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI < 0 || newJ < 0 || newI >= board.length || newJ >= board[0].length) {
                continue;
            }
            if (board[newI][newJ] == 1) {
                return true;
            }
        }
        return false;
    }

}
