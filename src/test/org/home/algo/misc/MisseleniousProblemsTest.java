package org.home.algo.misc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MisseleniousProblemsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findMissingElementsInSeries() {
        int[] input = {1,2,3,5,6,7,9,10};
        MisseleniousProblems.findMissingElementsInSeries(input);
    }

    @Test
    void rotateArrayByKBits() throws Exception {
        int[] input = {1,2,3,4,5,6,7};
        MisseleniousProblems.rotateArrayByKBits(input,3);
        int[] expected = {5,6,7,1,2,3,4};
        assertArrayEquals(expected,input);
    }

    @Test
    void swap() {
    }

    @Test
    void subsequenceOfThreeNumbersHavingMaximumProduct() {
    }

    @Test
    void keepOrdering() {
    }

    @Test
    void reverseSentence() {
    }

    @Test
    void reverseString() {
    }

    @Test
    void displayArray() {
    }

    @Test
    void displayArray1() {
    }

    @Test
    void findMissingElementsInSeries1() {
    }
}