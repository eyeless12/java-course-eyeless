package edu.hw6;

import edu.hw6.task2.Cloner;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ClonerTests {
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

    void createDirFile(Path dir, Path filePath) {
        try {
            Files.createDirectory(dir);
        } catch (IOException ignored) {
        }
        try {
            Files.createFile(filePath);
        } catch (IOException ignored) { }
    }

    @Test
    void testOneClone() throws IOException {
        var filename = "./clone_tests/clone";
        var filePath = Path.of(filename);
        var dir = filePath.getParent();
        createDirFile(dir, filePath);

        var cloner = new Cloner();
        cloner.cloneFile(filePath);

        var found = false;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                var existingFilename = file.getFileName();
                if (existingFilename.toString().equals("clone — копия")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThat(found).isEqualTo(true);
        deleteAllFilesOfDir(dir);
    }

    @Test
    void testTwoClone() throws IOException {
        var filename = "./clone_tests/clone";
        var filePath = Path.of(filename);
        var dir = filePath.getParent();
        createDirFile(dir, filePath);

        var cloner = new Cloner();
        cloner.cloneFile(filePath);
        cloner.cloneFile(filePath);

        var found = false;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                var existingFilename = file.getFileName();
                if (existingFilename.toString().equals("clone — копия (1)")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException ignored) {
        } finally {
            deleteAllFilesOfDir(dir);
        }
        assertThat(found).isEqualTo(true);
    }

    @Test
    void testRandomClones() throws IOException {
        var filename = "./clone_tests/clone";
        var filePath = Path.of(filename);
        var dir = filePath.getParent();
        createDirFile(dir, filePath);

        var cloner = new Cloner();
        var clonesCount = new Random().nextInt(4, 50);
        for (int i = 0; i < clonesCount; i++) {
            cloner.cloneFile(filePath);
        }

        var found = false;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                var existingFilename = file.getFileName();
                if (existingFilename.toString().equals(String.format("clone — копия (%d)", clonesCount - 1))) {
                    found = true;
                    break;
                }
            }
        } catch (IOException ignored) {
        } finally {
            deleteAllFilesOfDir(dir);
        }
        assertThat(found).isEqualTo(true);
    }
}
