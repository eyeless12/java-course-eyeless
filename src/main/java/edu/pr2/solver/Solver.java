package edu.pr2.solver;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import java.util.List;

public interface Solver {
    List<Cell> solve(Maze maze, Cell start, Cell end);
}
