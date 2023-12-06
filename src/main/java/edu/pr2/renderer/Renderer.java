package edu.pr2.renderer;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Cell> path);
}
