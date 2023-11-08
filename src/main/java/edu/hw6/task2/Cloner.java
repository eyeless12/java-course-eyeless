package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cloner {
    public void cloneFile(Path path) throws IOException {
        var parentDir = path.getParent();
        var filename = path.getFileName();

        var occurencies = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(parentDir)) {
            for (Path file : stream) {
                var existingFilename = file.getFileName();
                if (existingFilename.toString().startsWith(filename.toString())) {
                    occurencies++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path newFilePath;
        if (occurencies == 0) {
            throw new RuntimeException("file is not found");
        } else if (occurencies == 1) {
            newFilePath = Path.of(parentDir + "/" + filename + " — копия");
            Files.createFile(newFilePath);
        } else {
            var copyValue = String.format(" — копия (%s)", occurencies - 1);
            newFilePath = Path.of(parentDir + "/" + filename + copyValue);
            Files.createFile(newFilePath);
        }

        var data = Files.readAllLines(path);
        Files.writeString(newFilePath, String.join("\n", data));
    }
}
