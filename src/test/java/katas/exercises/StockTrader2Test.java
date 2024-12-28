package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTrader2Test {

    @Test
    void basicstockPrices(){
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(7, profit);
    }

    @Test
    void nullStockPrices(){
        int[] stockPrices = null;
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(0, profit);
    }

    @Test
    void emptyStockPrices(){
        int[] stockPrices = {};
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(0, profit);
    }

    @Test
    void oneStockPrice(){
        int[] stockPrices = {5};
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(0, profit);
    }

    @Test
    void equalStockPrices(){
        int[] stockPrices = {5, 5};
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(0, profit);
    }

    @Test
    void increasingStockPrices(){
        int[] stockPrices = {1, 2, 3, 4, 5};
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(4, profit);
    }

    @Test
    void decreasingStockPrices(){
        int[] stockPrices = {5, 4, 3, 2, 1};
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(0, profit);
    }

    @Test
    void zigZagStockPrices(){
        int[] stockPrices = {1, 4, 2, 5, 3, 7};
        int profit = StockTrader2.maxProfit(stockPrices);
        assertEquals(10, profit);
    }
}
