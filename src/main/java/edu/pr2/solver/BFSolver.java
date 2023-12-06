package edu.pr2.solver;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BFSolver implements Solver {
    @Override
    public List<Cell> solve(Maze maze, Cell start, Cell end) {
        var used = new HashSet<Cell>();
        var cellQueue = new LinkedList<Cell>();
        cellQueue.addFirst(start);
        while (!cellQueue.isEmpty()) {
            var cell = cellQueue.pollLast();
            used.add(cell);

            if (cell == end) {
                return new ArrayList<>(used);
            }

            var neighbours = maze.getNeighbours(cell);
            for (var neighbour : neighbours) {
                if (neighbour.type() != Cell.Type.WALL && !used.contains(neighbour)) {
                    cellQueue.addFirst(neighbour);
                }
            }
        }

        return null;
    }
}
