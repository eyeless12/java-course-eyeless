package edu.pr2;
import edu.pr2.generator.RecursiveBacktrackingGenerator;
import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import edu.pr2.solver.AStarSolver;
import edu.pr2.solver.BFSolver;
import edu.pr2.solver.DFSolver;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class LabyrinthTests {

    @Test
    void TestSmallLabyrinthBFS() {
        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        Cell start = getClosestPassageCell(maze).orElse(null);
        Cell end = getFarthestPassageCell(maze).orElse(null);

        assertThat(start).isNotNull();
        assertThat(end).isNotNull();

        var bfsolver = new BFSolver();
        var result = bfsolver.solve(maze, start, end);
        assertThat(result).isNotNull();
    }

    @Test
    void TestSmallLabyrinthDFS() {
        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        Cell start = getClosestPassageCell(maze).orElse(null);
        Cell end = getFarthestPassageCell(maze).orElse(null);

        assertThat(start).isNotNull();
        assertThat(end).isNotNull();

        var dfsolver = new DFSolver();
        var result = dfsolver.solve(maze, start, end);
        assertThat(result).isNotNull();
    }

    @Test
    void TestSmallLabyrinthAstar() {
        var mazeGenerator = new RecursiveBacktrackingGenerator(10, 10);
        var maze = mazeGenerator.generate();
        Cell start = getClosestPassageCell(maze).orElse(null);
        Cell end = getFarthestPassageCell(maze).orElse(null);

        assertThat(start).isNotNull();
        assertThat(end).isNotNull();

        var astarSolver = new AStarSolver();
        var result = astarSolver.solve(maze, start, end);
        assertThat(result).isNotNull();
    }

    private Optional<Cell> getClosestPassageCell(Maze maze) {
        for (var i = 0; i < maze.getWidth(); i++) {
            for (var j = 0; j < maze.getHeight(); j++) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    return Optional.of(cell);
                }
            }
        }
        return Optional.empty();
    }

    private Optional<Cell> getFarthestPassageCell(Maze maze) {
        for (var i = maze.getWidth() - 1; i >= 0; i--) {
            for (var j = maze.getHeight() - 1; j >= 0; j--) {
                var cell = maze.cellAt(i, j);
                if (cell.type() == Cell.Type.PASSAGE) {
                    return Optional.of(cell);
                }
            }
        }
        return Optional.empty();
    }
}
