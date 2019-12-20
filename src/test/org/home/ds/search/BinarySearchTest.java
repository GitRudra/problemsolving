package org.home.ds.search;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void regularBinarySearch() {
        Integer[] A = {-1, 2, 3, 5, 6, 8, 9, 10};
        BinarySearch<Integer> binSearch = new BinarySearch<>();
        binSearch.regularBinarySearch(A, 7, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Test
    public void optimalBinarySearch() {
        Integer[] A = {-1, 2, 3, 5, 6, 8, 9, 10};
        BinarySearch<Integer> binSearch = new BinarySearch<>();
        binSearch.optimalBinarySearch(A, 7, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }
}