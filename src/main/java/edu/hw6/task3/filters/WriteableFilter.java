package edu.hw6.task3.filters;

import java.io.IOException;
import java.nio.file.Path;

public class WriteableFilter extends AbstractFilter {
    @Override
    public boolean accept(Path entry) throws IOException {
        return entry.toFile().canWrite() && (next == null || next.accept(entry));
    }
}
