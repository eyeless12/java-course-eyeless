package edu.pr2.solver.heuristic;

import edu.pr2.maze.Cell;
import java.util.Comparator;

public class CellAStarHeuristic implements Comparator<Cell> {
    private final Cell end;

    public CellAStarHeuristic(Cell end) {
        this.end = end;
    }

    @Override
    public int compare(Cell o1, Cell o2) {
        return (int) (getHeuristic(o1) - getHeuristic(o2));
    }

    private double getHeuristic(Cell cell) {
        return Math.pow(end.col() - cell.col(), 2) + Math.pow(end.row() - cell.row(), 2);
    }
}
