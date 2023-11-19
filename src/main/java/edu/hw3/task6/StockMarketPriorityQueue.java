package edu.hw3.task6;

import java.util.PriorityQueue;

public class StockMarketPriorityQueue implements StockMarket {
    private final PriorityQueue<Stock> stocks =
            new PriorityQueue<>((Stock s1, Stock s2) -> Double.compare(s2.cost(), s1.cost()));

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
