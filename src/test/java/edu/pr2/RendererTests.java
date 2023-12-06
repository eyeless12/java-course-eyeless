package edu.pr2;

import edu.pr2.maze.Cell;
import edu.pr2.maze.Maze;
import edu.pr2.renderer.ConsoleRenderer;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RendererTests {
    @Test
    void testSmallMazeRender() {
        var renderer = new ConsoleRenderer();
        var maze = new Maze(3, 3,
            new Cell[][]{
                new Cell[] { new Cell(0, 0, Cell.Type.WALL), new Cell(0, 1, Cell.Type.WALL), new Cell(0, 2, Cell.Type.WALL),  },
                new Cell[] { new Cell(1, 0, Cell.Type.WALL), new Cell(1, 1, Cell.Type.PASSAGE), new Cell(1, 2, Cell.Type.WALL),  },
                new Cell[] { new Cell(2, 0, Cell.Type.WALL), new Cell(2, 1, Cell.Type.WALL), new Cell(2, 2, Cell.Type.WALL),  }
            });
        var result = renderer.render(maze);
        var expected = "---\n" +
            "| |\n" +
            "---\n";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testSmallMazeRenderWithPassage() {
        var renderer = new ConsoleRenderer();
        var maze = new Maze(3, 3,
            new Cell[][]{
                new Cell[] { new Cell(0, 0, Cell.Type.WALL), new Cell(0, 1, Cell.Type.WALL), new Cell(0, 2, Cell.Type.WALL),  },
                new Cell[] { new Cell(1, 0, Cell.Type.PASSAGE), new Cell(1, 1, Cell.Type.PASSAGE), new Cell(1, 2, Cell.Type.PASSAGE),  },
                new Cell[] { new Cell(2, 0, Cell.Type.WALL), new Cell(2, 1, Cell.Type.WALL), new Cell(2, 2, Cell.Type.WALL),  }
            });
        var exitPath = List.of(new Cell(1, 0, Cell.Type.PASSAGE), new Cell(1, 1, Cell.Type.PASSAGE), new Cell(1, 2, Cell.Type.PASSAGE));

        var result = renderer.render(maze,exitPath);

        var expected = "---\n" +
            "●●●\n" +
            "---\n";
        assertThat(result).isEqualTo(expected);
    }
}
