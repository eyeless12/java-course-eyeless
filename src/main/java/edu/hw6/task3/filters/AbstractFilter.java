package edu.hw6.task3.filters;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public abstract class AbstractFilter implements DirectoryStream.Filter<Path> {
    protected AbstractFilter next;

    public AbstractFilter and(AbstractFilter filter) {
        AbstractFilter lookAt = this;
        while (lookAt.next != null) {
            lookAt = lookAt.next;
        }
        lookAt.next = filter;
        return this;
    }
}
