package edu.hw10;

import edu.hw10.annotations.Max;
import edu.hw10.annotations.Min;
import edu.hw10.annotations.NotNull;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomObjectGeneratorTest {
    public record TestRecord(@NotNull String word, @Min(value = 1) @Max(value = 5)int number) {}

    public static class TestClass {
        private final String word;
        private final int number;

        public TestClass(@NotNull String word, @Min(value = 1) @Max(value = 5)int number) {
            this.word = word;
            this.number = number;
        }

        public static TestClass create(@NotNull String word, @Min(value = 10) @Max(value = 15)int number) {
            return new TestClass(word + "_check", number);
        }

        public String getWord() {
            return word;
        }

        public int getNumber() {
            return number;
        }
    }

    @Test
    void record() {
        TestRecord record = (TestRecord) RandomObjectGenerator.nextObject(TestRecord.class);

        assertThat(record).isNotNull();
        assertThat(record.word).isNotNull();
        assertThat(record.number).isBetween(1, 5);
    }

    @Test
    void pojo() {
        TestClass testClass = (TestClass) RandomObjectGenerator.nextObject(TestClass.class);

        assertThat(testClass).isNotNull();
        assertThat(testClass.getWord()).isNotNull();
        assertThat(testClass.getNumber()).isBetween(1, 5);
    }

    @Test
    void pojoCreate() {
        TestClass testClass = (TestClass) RandomObjectGenerator.nextObject(TestClass.class, "create");

        assertThat(testClass).isNotNull();
        assertThat(testClass.getWord()).isNotNull();
        assertThat(testClass.getWord().substring(testClass.getWord().length() - 6))
                .isEqualTo("_check");
        assertThat(testClass.getNumber()).isBetween(10, 15);
    }
}
