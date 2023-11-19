package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ContactParser {
    private ContactParser() {
    }

    public static Contact[] parseContacts(Collection<String> names, SortOrder order) {
        if (names == null) {
            return new Contact[0];
        }
        var result = new ArrayList<Contact>();
        for (String name : names) {
            var parsed = name.split(" ");
            result.add(new Contact(parsed[0], parsed.length == 1 ? "" : parsed[1]));
        }
        Collections.sort(result);
        if (order == SortOrder.DESC) {
            Collections.reverse(result);
        }
        return result.toArray(result.toArray(new Contact[0]));
    }
}
