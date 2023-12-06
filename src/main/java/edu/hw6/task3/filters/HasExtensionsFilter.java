package edu.hw6.task3.filters;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class HasExtensionsFilter extends AbstractFilter {
    private final String[] allowedExtensions;

    public HasExtensionsFilter(String[] allowedExtensions) {
        this.allowedExtensions = allowedExtensions;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return Arrays.stream(allowedExtensions)
                .anyMatch(extension -> entry.getFileName().toString().endsWith(extension))
                && (next == null || next.accept(entry));
    }
}
