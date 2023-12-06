package edu.pr2.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width, Cell[][] grid) {
        if (height <= 0 || width <= 0 || grid == null) {
            throw new IllegalArgumentException();
        }
        this.height = height;
        this.width = width;
        this.grid = grid;
    }

    public Cell cellAt(int i, int j) {
        return grid[i][j];
    }

    public Optional<Cell> left(Cell cell) {
        if (cell.col() > 0) {
            return Optional.of(cellAt(cell.row(), cell.col() - 1));
        }
        return Optional.empty();
    }

    public Optional<Cell> right(Cell cell) {
        if (cell.col() < width - 1) {
            return Optional.of(cellAt(cell.row(), cell.col() + 1));
        }
        return Optional.empty();
    }

    public Optional<Cell> up(Cell cell) {
        if (cell.row() > 0) {
            return Optional.of(cellAt(cell.row() - 1, cell.col()));
        }
        return Optional.empty();
    }

    public Optional<Cell> down(Cell cell) {
        if (cell.row() < height - 1) {
            return Optional.of(cellAt(cell.row() + 1, cell.col()));
        }
        return Optional.empty();
    }

    public List<Cell> getNeighbours(Cell cell) {
        var result = new ArrayList<Cell>();

        var cellI = cell.row();
        var cellJ = cell.col();

        var newCellI = cellI - 1;
        if (newCellI >= 0) {
            result.add(this.cellAt(newCellI, cellJ));
        }

        newCellI = cellI + 1;
        if (newCellI < height) {
            result.add(this.cellAt(newCellI, cellJ));
        }

        var newCellJ = cellJ - 1;
        if (newCellJ >= 0) {
            result.add(this.cellAt(cellI, newCellJ));
        }

        newCellJ = cellJ + 1;
        if (newCellJ < width) {
            result.add(this.cellAt(cellI, newCellJ));
        }

        return result;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
