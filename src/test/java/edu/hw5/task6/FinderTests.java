package edu.hw5.task6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FinderTests {
    @Test
    public void testSubstringInBeginning() {
        var sub = "abc";
        var str = "abcgijahygtahijgha";

        assertThat(Finder.isSubsequence(sub, str)).isEqualTo(true);
    }

    @Test
    public void testSubstringInEnd() {
        var sub = "abc";
        var str = "gijahygtahijghabc";

        assertThat(Finder.isSubsequence(sub, str)).isEqualTo(true);
    }

    @Test
    public void testSubstringInMiddle() {
        var sub = "abc";
        var str = "gijahygtabchijgh";

        assertThat(Finder.isSubsequence(sub, str)).isEqualTo(true);
    }

    @Test
    public void testSubstringNotInStr() {
        var sub = "abc";
        var str = "gijahygtachijgh";

        assertThat(Finder.isSubsequence(sub, str)).isEqualTo(false);
    }
}
