package edu.hw6;

import edu.hw6.task1.DiskMap;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DiskMapTests {
    void deleteAllFilesOfDir(Path dirPath) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath)) {
            for (Path file : stream) {
                Files.delete(file);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Files.delete(dirPath);
    }

    void deleteFile(Path filePath) {
        try {
            Files.delete(filePath);
        } catch (IOException ignored) { }
    }

    @Test
    void settingGetting() throws IOException {
        var map = new DiskMap("./file1");
        map.set("0", "0123");
        var result = map.get("0");
        assertThat(result).isEqualTo("0123");
        deleteAllFilesOfDir(Path.of("./file1"));
    }

    @Test
    void savingLoadingContext() throws IOException {
        var map = new DiskMap("./file2");
        map.set("0", "0123");
        map.set("1", "1234");

        map.saveContext("./file_saved");
        var newMap = new DiskMap("./file_new");
        newMap.loadContext("./file_saved");

        assertThat(newMap.get("1")).isEqualTo("1234");
        deleteAllFilesOfDir(Path.of("./file2"));
        deleteAllFilesOfDir(Path.of("./file_new"));
        deleteFile(Path.of("./file_saved"));
    }
}
