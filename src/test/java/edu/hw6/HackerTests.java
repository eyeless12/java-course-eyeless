package edu.hw6;

import edu.hw6.task5.HackerNews;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HackerTests {
    @Test
    void testGetting() {
        var newsGetter = new HackerNews();
        var result = newsGetter.hackerNewsTopStories();
        assertThat(result.length).isGreaterThan(0);
    }

    @Test
    void testNews() {
        var newsGetter = new HackerNews();
        assertThat(newsGetter.news(37570037)).isEqualTo("\"JDK 21 Release Notes\"");
        assertThat(newsGetter.news(38212653)).isEqualTo("\"No Man's Sky just keeps getting better\"");
        assertThat(newsGetter.news(38202522)).isEqualTo("\"EU Digital Identity to Login to Facebook, Twitter and Other VLOPs\"");
    }
}
