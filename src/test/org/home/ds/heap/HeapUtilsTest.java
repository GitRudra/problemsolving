package org.home.ds.heap;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HeapUtilsTest {

    @Test
    public void findKthLargestElementOne() throws Exception {
        HeapUtils heap = new HeapUtils();
        int arr[] = {1, 23, 12, 9, 30, 2, 50};
        ArrayList input = new ArrayList();
        Integer expected = 9;
        for(int x:arr){
            input.add(x);
        }
        Integer actual  = heap.findKthLargestElement(input,5);
        System.out.println(actual);
        assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findKthLargestElementTwo() throws Exception {
        HeapUtils heap = new HeapUtils();
        int arr[] = {1, 23, 12};
        ArrayList input = new ArrayList();
        Integer expected = 9;
        for(int x:arr){
            input.add(x);
        }
        Integer actual  = heap.findKthLargestElement(input,5);
    }
}