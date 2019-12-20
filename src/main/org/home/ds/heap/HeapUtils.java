package org.home.ds.heap;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapUtils {

    public HeapUtils() {
    }

    public Integer findKthLargestElement(ArrayList<Integer> input, int k) throws Exception {

        @SuppressWarnings("unchecked")
        Heap<Integer> h = new MinHeap(k,  new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for(Integer x : input){
            h.insert(x);
        }

        if(h.size()<k){
            throw new IllegalArgumentException("Number of element is less than "+ k);
        }
        return h.getTop();
    }
}
