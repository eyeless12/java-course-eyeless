package edu.hw3;

import edu.hw3.task2.Clusterizator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    void NoInnerBraces() {
        var initial = "()()()";
        var result = Clusterizator.clusterize(initial);
        assertThat(result).containsExactly("()", "()", "()");
    }

    @Test
    void InnerBraces() {
        var initial = "((()))(())()()(()())";
        var result = Clusterizator.clusterize(initial);
        assertThat(result).containsExactly("((()))", "(())", "()", "()", "(()())");
    }

    @Test
    void Empty() {
        var initial = "";
        var result = Clusterizator.clusterize(initial);
        assertThat(result).isEmpty();
    }
}
