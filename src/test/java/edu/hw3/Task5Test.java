package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.ContactParser;
import edu.hw3.task5.SortOrder;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    void SimpleContacts() {
        var values = List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        var resultASC = ContactParser.parseContacts(values, SortOrder.ASC);
        var resultDESC = ContactParser.parseContacts(values, SortOrder.DESC);
        var expected = List.of(new Contact("Thomas", "Aquinas"),
                new Contact("Rene", "Descartes"),
                new Contact("David", "Hume"),
                new Contact("John", "Locke"));
        assertThat(resultASC).containsExactlyElementsOf(expected);
        assertThat(resultDESC).containsExactlyElementsOf(expected.reversed());
    }

    @Test
    void OnlyNames() {
        var values = List.of("John", "Thomas Aquinas", "David", "Rene Descartes");
        var resultASC = ContactParser.parseContacts(values, SortOrder.ASC);
        var resultDESC = ContactParser.parseContacts(values, SortOrder.DESC);
        var expected = List.of(new Contact("Thomas", "Aquinas"),
                new Contact("David", ""),
                new Contact("Rene", "Descartes"),
                new Contact("John", ""));
        assertThat(resultASC).containsExactlyElementsOf(expected);
        assertThat(resultDESC).containsExactlyElementsOf(expected.reversed());
    }

    @Test
    void Empty() {
        ArrayList<String> values = new ArrayList<>();
        var resultASC = ContactParser.parseContacts(values, SortOrder.ASC);
        assertThat(resultASC).isEmpty();
    }

    @Test
    void Null() {
        ArrayList<String> values = null;
        var resultASC = ContactParser.parseContacts(values, SortOrder.ASC);
        assertThat(resultASC).isEmpty();
    }
}
