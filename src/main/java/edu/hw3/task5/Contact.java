package edu.hw3.task5;

import org.jetbrains.annotations.NotNull;

public record Contact(String name, String surname) implements Comparable<Contact> {
    @Override
    public int compareTo(@NotNull Contact o) {
        var thisToCompare = this.surname + this.name;
        var oToCompare = o.surname + o.name;
        return thisToCompare.compareTo(oToCompare);
    }
}
