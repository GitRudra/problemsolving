package org.home.algo.misc;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class UpsideDownNumbersTest {

    HashSet<Integer> nonConfusingDigits = new HashSet<>();
    HashMap<Integer, Integer> confusingDigitsMap = new HashMap<>();
    @Test
    public void getUpSideDownNumber() {
        UpsideDownNumbers chcek = new UpsideDownNumbers();
        int num = 61;
        int expected = 19;
        assertTrue(chcek.isConfusing(num,nonConfusingDigits,confusingDigitsMap));
    }

    @Test
    public void getUpSideDownNumberTwo() {
        UpsideDownNumbers chcek = new UpsideDownNumbers();
        int num = 65;
        int expected = 19;
        assertFalse(chcek.isConfusing(num,nonConfusingDigits,confusingDigitsMap));
    }

    @Before
    public void setUp() throws Exception {
        nonConfusingDigits.add(2);
        nonConfusingDigits.add(3);
        nonConfusingDigits.add(4);
        nonConfusingDigits.add(5);
        nonConfusingDigits.add(7);
        confusingDigitsMap.put(6,9);
        confusingDigitsMap.put(9,6);
    }
}