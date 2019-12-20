package org.home.algo.online;

import org.home.ds.heap.Heap;

import java.util.Comparator;

/**
 * use a max heap on left side to represent elements that are
 * less than effective median, and a min heap on right side to
 * represent elements that are greater than effective median.
 * <p>
 * After processing an incoming element,
 * the number of elements in heaps differ utmost by 1 element.
 * When both heaps contain same number of elements,
 * we pick average of heaps root data as effective median.
 * When the heaps are not balanced, we select effective median
 * from the root of heap containing more elements.
 */
public class MedianOfRunningStreamOfInteger {

    //The min heap as mentioned above
    private Heap<Integer> rightHeap;

    //The max heap as mentioned above
    private Heap<Integer> leftHeap;

    //Heap Size
    private int MAX_SIZE;

    public MedianOfRunningStreamOfInteger(int maxSize) {
        this.MAX_SIZE = maxSize;
        rightHeap = new Heap<>(MAX_SIZE, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        leftHeap = new Heap<>(MAX_SIZE, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
    }

    /**
     * @param x the new element
     * @param m median up to last element arrived.
     * @return median up to the element x
     * @throws Exception
     */
    public int getEffectiveMedian(int x, int m) throws Exception {
        int effectiveMedian;

        // The left and right heaps contain same number of elements
        if (leftHeap.size() == rightHeap.size()) {
            // current element fits in left (max) heap
            if (x < m) {
                leftHeap.insert(x);
                effectiveMedian = leftHeap.getTop();
            } else {
                // current element fits in right (min) heap
                rightHeap.insert(x);
                effectiveMedian = rightHeap.getTop();
            }
            // There are more elements in right (min) heap
        } else if (leftHeap.size() < rightHeap.size()) {
            // current element fits in left (max) heap
            if (x < m) {
                leftHeap.insert(x);
            } else {
                // Remove top element from right heap and
                // insert into left heap
                leftHeap.insert(rightHeap.removeTop());
                // current element fits in right (min) heap
                rightHeap.insert(x);
            }
            // Both heaps are balanced
            effectiveMedian = (leftHeap.getTop() + rightHeap.getTop()) / 2;
            // There are more elements in left (max) heap
        } else {
            if (x < m) {
                // Remove top element from left heap and
                // insert into right heap
                rightHeap.insert(leftHeap.removeTop());
                // current element fits in left (max) heap
                leftHeap.insert(x);
            } else {
                // current element fits in right (min) heap
                rightHeap.insert(x);
            }
            // Both heaps are balanced
            effectiveMedian = (leftHeap.getTop() + rightHeap.getTop()) / 2;
        }

        return effectiveMedian;
    }
}
