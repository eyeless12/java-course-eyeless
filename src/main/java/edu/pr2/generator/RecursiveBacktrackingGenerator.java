package edu.pr2.generator;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import java.util.Random;

public class RecursiveBacktrackingGenerator implements Generator {
    private final int width;
    private final int height;
    private final char[][] maze;
    private final Random random;
    private final static int[] DIRECTIONS = {0, 1, 2, 3};
    private final static int RIGHT = 0;
    private final static int LEFT = 1;
    private final static int DOWN = 2;
    private final static int UP = 3;
    private final static int STEP = 2;

    public RecursiveBacktrackingGenerator(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
        this.maze = new char[height + 1][width + 1];
        this.random = new Random();
    }

    private void initializeMaze() {
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                maze[i][j] = '#';
            }
        }
    }

    private void generateMaze(int x, int y) {
        maze[y][x] = ' ';

        int[] directions = DIRECTIONS;
        shuffleArray(directions);

        for (int direction : directions) {
            int dx = 0;
            int dy = 0;

            if (direction == RIGHT) {
                dx = STEP;
            } else if (direction == LEFT) {
                dx = -STEP;
            } else if (direction == DOWN) {
                dy = STEP;
            } else if (direction == UP) {
                dy = -STEP;
            }

            int nx = x + dx;
            int ny = y + dy;

            if (nx >= 1 && nx < width && ny >= 1 && ny < height && maze[ny][nx] == '#') {
                maze[y + dy / 2][x + dx / 2] = ' ';
                generateMaze(nx, ny);
            }
        }
    }

    private void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    @Override
    public Maze generate() {
        initializeMaze();
        generateMaze(1, 1);
        var cellArray = new Cell[height + 1][width + 1];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                cellArray[i][j] = new Cell(i, j, maze[i][j] == '#' ? Cell.Type.WALL : Cell.Type.PASSAGE);
            }
        }
        return new Maze(height + 1, width + 1, cellArray);
    }
}

