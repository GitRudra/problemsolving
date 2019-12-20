package org.home.cmp.ms.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperStringReducerTest {

    @Test
    void superReducedString1() {
        String inputString = "aaabccddd";
        String expected = "abd";
        String actual = SuperStringReducer.superReducedString(inputString);
        assertEquals(expected,actual);
    }

    @Test
    void superReducedString2() {
        String inputString = "aaaabccbdd";
        String expected = "Empty String";
        String actual = SuperStringReducer.superReducedString(inputString);
        assertEquals(expected,actual);
    }
    @Test
    void reduceString() {
    }
}