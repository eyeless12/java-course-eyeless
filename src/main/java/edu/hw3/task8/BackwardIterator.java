package edu.hw3.task8;

import java.util.Iterator;

public class BackwardIterator<T> implements Iterator<T> {
    private Entry<T> entry;

    public BackwardIterator(Iterable<T> collection) {
        for (T t : collection) {
            entry = new Entry<>(t, entry);
        }
    }

    @Override
    public boolean hasNext() {
        return entry != null;
    }

    @Override
    public T next() {
        T entryValue = entry.current;
        entry = entry.next;
        return entryValue;
    }

    private record Entry<T>(T current, BackwardIterator.Entry<T> next) {
    }
}
