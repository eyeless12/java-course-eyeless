package edu.hw8;

import edu.hw8.threadPool.Tester;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ThreadPoolTests {
    @Test
    void testResults() throws InterruptedException {
        var resultsAsync = Tester.testThreadPool();
        var resultSync = Tester.testSynchrone();
        assertThat(resultsAsync).containsExactly(resultSync);
    }
}
