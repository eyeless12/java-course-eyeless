package edu.hw6;

import edu.hw6.task4.Task;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

public class FourTests {
    @Test
    void testDoing() throws IOException {
        var resPath = Path.of("./task");
        Task.task(resPath);
        var result = Files.readAllLines(resPath).get(0);
        assertThat(result).isEqualTo("Programming is learned by writing programs. ― Brian Kernighan");
        Files.delete(resPath);
    }
}
