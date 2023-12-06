package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Task {
    private Task() { }

    public static void task(Path path) throws IOException {
        try (var file = Files.newOutputStream(path)) {
            var checkedOutput = new CheckedOutputStream(file, new Adler32());
            try (var buffered = new BufferedOutputStream(checkedOutput)) {
                var outputStreamWriter = new OutputStreamWriter(buffered, StandardCharsets.UTF_8.newEncoder());
                var printWriter = new PrintWriter(outputStreamWriter);
                printWriter.write("Programming is learned by writing programs. ― Brian Kernighan");
                printWriter.close();
            }
        }
    }
}
