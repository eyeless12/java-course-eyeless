package edu.hw6.task3.prog;

import edu.hw6.task3.filters.AbstractFilter;
import edu.hw6.task3.filters.HasExtensionsFilter;
import edu.hw6.task3.filters.ReadableFilter;
import edu.hw6.task3.filters.RegexFilenameFilter;

public class Example {
    private Example() { }

    public static final AbstractFilter READABLE = new ReadableFilter();
    public static final AbstractFilter HAS_EXTENSIONS = new HasExtensionsFilter(new String[] {"txt", "png"});
    public static final AbstractFilter HAS_NAME = new RegexFilenameFilter("^file$");
}
