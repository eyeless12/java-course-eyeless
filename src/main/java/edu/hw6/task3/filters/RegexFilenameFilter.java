package edu.hw6.task3.filters;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class RegexFilenameFilter extends AbstractFilter {
    private final Pattern pattern;

    public RegexFilenameFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return pattern.matcher(entry.getFileName().toString()).find() && (next == null || next.accept(entry));
    }
}
