package edu.hw3.task6;

interface StockMarket {
    /**
     * Добавить акцию
     */
    void add(Stock stock);

    /**
     * Удалить акцию
     */
    void remove(Stock stock);

    /**
     * Самая дорогая акция
     */
    Stock mostValuableStock();
}
