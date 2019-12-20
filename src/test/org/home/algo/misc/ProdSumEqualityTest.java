package org.home.algo.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdSumEqualityTest {

    @Test
    void getPairsOne() {
        int n=10;
        ProdSumEquality.getPairs(n);
    }

    @Test
    void getPairsTwo() {
        int n=20;
        ProdSumEquality.getPairs(n);
    }
    @Test
    void getPairsThree() {
        int n=30;
        ProdSumEquality.getPairs(n);
    }
    @Test
    void getPairsFour() {
        int n=40;
        ProdSumEquality.getPairs(n);
    }

    @Test
    void getPairsFive() {
        int n=50;
        ProdSumEquality.getPairs(n);
    }
}