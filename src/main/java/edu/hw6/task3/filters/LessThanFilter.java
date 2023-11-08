package edu.hw6.task3.filters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LessThanFilter extends AbstractFilter {
    private final long filterSize;

    public LessThanFilter(long sizeInBytes) {
        filterSize = sizeInBytes;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return Files.size(entry) < filterSize && (next == null || next.accept(entry));
    }
}
