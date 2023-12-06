package edu.pr2.solver;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import edu.pr2.solver.heuristic.CellAStarHeuristic;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import org.jetbrains.annotations.NotNull;

public class AStarSolver implements Solver {
    @Override
    public List<Cell> solve(Maze maze, @NotNull Cell start, @NotNull Cell end) {
        if (start.type() == Cell.Type.WALL || end.type() == Cell.Type.WALL) {
            throw new IllegalArgumentException();
        }

        var used = new HashSet<Cell>();
        var cellQueue = new PriorityQueue<>(new CellAStarHeuristic(end));
        cellQueue.add(start);
        while (!cellQueue.isEmpty()) {
            var cell = cellQueue.poll();
            used.add(cell);

            if (cell == end) {
                return new ArrayList<>(used);
            }

            var neighbours = maze.getNeighbours(cell);
            for (var neighbour : neighbours) {
                if (neighbour.type() != Cell.Type.WALL && !used.contains(neighbour)) {
                    cellQueue.add(neighbour);
                }
            }
        }

        return null;
    }
}
