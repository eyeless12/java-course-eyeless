package edu.hw5.task2;

import static edu.hw5.task2.UnluckyFridays.getAllUnluckyFridays;
import static edu.hw5.task2.UnluckyFridays.getClosestUnluckyFriday;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class FridayTests {
    @Test
    public void allUnluckyFridays() {
        var result1925 = getAllUnluckyFridays(1925);
        var result2024 = getAllUnluckyFridays(2024);

        assertThat(result1925).containsExactly("1925-02-13", "1925-03-13", "1925-11-13");
        assertThat(result2024).containsExactly("2024-09-13", "2024-12-13");
    }

    @Test
    public void closestUnluckyFridayNotToday() {
        var date = "2024-09-13";
        assertThat(getClosestUnluckyFriday(date)).isEqualTo("2024-12-13");
    }

    @Test
    public void closestUnluckyFridayTomorrow() {
        var date = "2024-09-12";
        assertThat(getClosestUnluckyFriday(date)).isEqualTo("2024-09-13");
    }
}
