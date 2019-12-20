package org.home.ds.search;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class RandomizeBinarySearchTest {

    @Test
    public void randomizeBinarySearchTest01() {
        Integer[] A = {-1, 2, 3, 5, 6, 8, 9, 10};
        RandomizeBinarySearch<Integer> binSearch = new RandomizeBinarySearch<>();
        Boolean isFound = binSearch.search(A, 7, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        assertFalse(isFound);
    }
    @Test
    public void randomizeBinarySearchTest02Success() {
        Integer[] A = {-1, 2, 3, 5, 6, 8, 9, 10};
        RandomizeBinarySearch<Integer> binSearch = new RandomizeBinarySearch<>();
        Boolean isFound = binSearch.search(A, 8, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        assertTrue(isFound);
    }

    @Test
    public void randomizeBinarySearchTest03SuccessUpperBound() {
        Integer[] A = {-1, 2, 3, 5, 6, 8, 9, 10};
        RandomizeBinarySearch<Integer> binSearch = new RandomizeBinarySearch<>();
        Boolean isFound = binSearch.search(A, 10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        assertTrue(isFound);
    }

    @Test
    public void randomizeBinarySearchTest03SuccessLowerBound() {
        Integer[] A = {-1, 2, 3, 5, 6, 8, 9, 10};
        RandomizeBinarySearch<Integer> binSearch = new RandomizeBinarySearch<>();
        Boolean isFound = binSearch.search(A, -1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        assertTrue(isFound);
    }

    @Test
    public void getRandomizePivot() {

    }
}