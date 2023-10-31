package edu.pr2.solver;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFSolver implements Solver {
    @Override
    public List<Cell> solve(Maze maze, Cell start, Cell end) {
        var used = new HashSet<Cell>();
        var cellStack = new Stack<Cell>();
        cellStack.push(start);
        while (!cellStack.isEmpty()) {
            var cell = cellStack.pop();
            used.add(cell);

            if (cell == end) {
                return new ArrayList<>(used);
            }

            var neighbours = maze.getNeighbours(cell);
            for (var neighbour : neighbours) {
                if (neighbour.type() != Cell.Type.WALL && !used.contains(neighbour)) {
                    cellStack.push(neighbour);
                }
            }
        }

        return null;
    }
}
