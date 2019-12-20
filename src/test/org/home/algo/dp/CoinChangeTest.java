package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {

    @Test
    public void findCoinChangeRecursively() {
        CoinChange cc = new CoinChange();
        int coins[] = {1, 2, 3};
        int targetAmount = 4;
        int expectedValue =4;
        int actual = cc.findCoinChangeRecursively(coins,coins.length,targetAmount);
        assertEquals(expectedValue,actual);
    }

    @Test
    public void findCoinChangeRecursivelyTwo() {
        CoinChange cc = new CoinChange();
        int coins[] = {1, 2, 3};
        int targetAmount = 4;
        int expectedValue =4;
        int actual = cc.coinChangeDPSolution(coins,coins.length,targetAmount);
        assertEquals(expectedValue,actual);
    }
}