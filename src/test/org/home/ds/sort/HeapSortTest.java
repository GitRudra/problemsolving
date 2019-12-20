package org.home.ds.sort;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void sort() {
        Integer arr[] = {1, 23, 12, 9, 30, 2, 50};
        HeapSort sort = new HeapSort(Integer.class, arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        sort.sort();
        sort.printHeap();
    }
}