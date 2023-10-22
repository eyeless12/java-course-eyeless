package edu.hw3;

import edu.hw3.task7.NullComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    void Simple() {
        var map = new TreeMap<String, String>(new NullComparator());
        map.put("c", "k");
        map.put(null, "a");
        map.put("e", "b");
        assertThat(map.containsKey(null)).isEqualTo(true);
        assertThat(map.get(null)).isEqualTo("a");
        map.put(null, "e");
        assertThat(map.containsKey(null)).isEqualTo(true);
        assertThat(map.get(null)).isEqualTo("e");
        map.remove(null);
        assertThat(map.containsKey(null)).isEqualTo(false);
    }
}
