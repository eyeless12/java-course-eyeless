package edu.pr2.renderer;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import java.util.List;

public class ConsoleRenderer implements Renderer {
    private final static char WALL = (char) 9633;
    private final static char WALL_HORIZONTAL = '-'; //'⎯';
    private final static char WALL_VERTICAL = '|';
    private final static char PATH = (char) 9679;
    private final static char EMPTY = ' ';

    @Override
    public String render(Maze maze) {
        var sb = new StringBuilder();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                var cell = maze.cellAt(i, j);
                var ch = getPrettyCharacters(cell, maze);

                sb.append(ch);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String render(Maze maze, List<Cell> path) {
        var result = new char[maze.getHeight()][maze.getWidth()];

        var sb = new StringBuilder();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                var cell = maze.cellAt(i, j);

                var ch = getPrettyCharacters(cell, maze);
                result[i][j] = ch;
            }
        }
        for (var cell : path) {
            result[cell.row()][cell.col()] = PATH;
        }

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private char getPrettyCharacters(Cell cell, Maze maze) {
        if (cell.type() != Cell.Type.WALL) {
            return EMPTY;
        }
        var left = maze.left(cell);
        var right = maze.right(cell);
        var up = maze.up(cell);
        var down = maze.down(cell);
        if (left != null && left.type() == Cell.Type.WALL
                || right != null && right.type() == Cell.Type.WALL) {
            return WALL_HORIZONTAL;
        }
        if (up != null && up.type() == Cell.Type.WALL
                || down != null && down.type() == Cell.Type.WALL) {
            return WALL_VERTICAL;
        }

        return WALL;
    }
}
