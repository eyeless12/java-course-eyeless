package edu.hw6.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DiskMap {
    private final String directory = System.getProperty("user.dir") + "/files";
    private final Path path;

    public DiskMap() {
        path = Paths.get(directory);
        try {
            Files.createDirectory(path);
        } catch (IOException ignored) {
        }
    }

    public String get(String key) throws IOException {
        Path dir = Path.of(directory + "/" + key);
        return Files.readAllLines(dir).get(0).split(":")[1];
    }

    public void set(String key, String value) throws IOException {
        Path dir = Path.of(directory + "/" + key);
        var file = new File(directory + "/" + key);
        if (file.exists()) {
            var data = Files.readAllLines(dir).get(0).split(":");
            data[1] = value;
        } else {
            Files.createFile(dir);
        }
        Files.writeString(dir, key + ":" + value);
    }

    public void saveContext(String path) throws IOException {
        Path dir = Path.of(directory);
        var data = new ArrayList<String>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                data.add(Files.readAllLines(file).get(0));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var outPath = Path.of(path);
        Files.createFile(outPath);
        Files.writeString(outPath, String.join("\n", data));
    }

    public void loadContext(String path) throws IOException {
        Path dir = Path.of(path);
        var data = new ArrayList<>(Files.readAllLines(dir));

        for (var line : data) {
            var splitted = line.split(":");
            var key = splitted[0];
            var value = splitted[1];
            set(key, value);
        }
    }
}
