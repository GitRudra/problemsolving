package org.home.ds.array;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StockBuySellProblemTest {

    @Test
    public void testFindMaximumProfit() {
        StockBuySellProblem stockBroker = new StockBuySellProblem();
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        stockBroker.findMaximumProfit(price).stream().forEach(e-> System.out.println(e));
    }

}