package edu.hw3;

import edu.hw3.task1.Atbash;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    void Hello() {
        String initial = "Hello, world!";
        String result = Atbash.cypher(initial);
        assertThat(result).isEqualTo("Svool, dliow!");
    }

    @Test
    void NonCyrilic() {
        String initial = "1245158%782157189";
        String result = Atbash.cypher(initial);
        assertThat(result).isEqualTo(initial);
    }

    @Test
    void Empty() {
        String initial = "";
        String result = Atbash.cypher(initial);
        assertThat(result).isEqualTo(initial);
    }

    @Test
    void Register() {
        String initial = "Az";
        String result = Atbash.cypher(initial);
        assertThat(result).isEqualTo("Za");
    }
}
