package edu.hw6.task3.prog;

import edu.hw6.task3.filters.AbstractFilter;
import edu.hw6.task3.filters.HasExtensionsFilter;
import edu.hw6.task3.filters.ReadableFilter;
import edu.hw6.task3.filters.RegexFilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example {
    private Example() { }

    public static final AbstractFilter READABLE = new ReadableFilter();
    public static final AbstractFilter HAS_EXTENSIONS = new HasExtensionsFilter(new String[] {"txt", "png"});
    public static final AbstractFilter HAS_NAME = new RegexFilenameFilter("^file$");

    public static void main(String[] args) {
        DirectoryStream.Filter<Path> filter = READABLE.and(HAS_EXTENSIONS);

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(
                Path.of(System.getProperty("user.dir") + "/files"), filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
