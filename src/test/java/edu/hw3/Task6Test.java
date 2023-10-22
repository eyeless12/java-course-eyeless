package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarketPriorityQueue;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Task6Test {
    @Test
    void TestRemove() {
        var market = new StockMarketPriorityQueue();
        var stock = new Stock("Apple", 50);
        market.add(stock);
        assertThat(market.mostValuableStock()).matches((s -> s.name().equals("Apple")));
        market.remove(stock);
        assertThat(market.mostValuableStock()).isEqualTo(null);
    }

    @Test
    void TestValuable() {
        var market = new StockMarketPriorityQueue();
        var ans = new Stock("c", 15);
        var stocks = List.of(new Stock("a", 3),
                new Stock("b", 7),
                ans,
                new Stock("d", 9),
                new Stock("d", 14));
        for (Stock s : stocks) {
            market.add(s);
        }
        assertThat(market.mostValuableStock()).isEqualTo(ans);
    }
}
