package org.home.ds.heap;

import java.util.Comparator;

public class HeapExecutor {
    public static void main(String[] args) throws Exception {
        HeapExecutor executor = new HeapExecutor();
        executor.executeThree();
    }

    private void executeThree() throws Exception {

        int kthSize = 3;
        @SuppressWarnings("unchecked")
        Heap<Integer> minHeap = new MinHeap(kthSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        @SuppressWarnings("unchecked")
        Heap<Integer> maxHeap = new MaxHeap<>(kthSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        int[] input = {11, 9, 22, 55, 44, 33, 3, 21, 8};
        for (int i = 0; i < input.length; i++) {
            minHeap.insert(input[i]);
            maxHeap.insert(input[i]);
            if (i >= kthSize) {
                System.out.println(kthSize + "Min Element till now : " + maxHeap.getTop());
                System.out.println(kthSize + "Max Element till now : " + minHeap.getTop());
            }
        }
    }
}
