package org.home.ds.heap;

import java.util.Comparator;

public class MaxHeap<E> extends Heap<E> {

    public MaxHeap(int heapSize, Comparator comp) {
        super(heapSize, comp);
    }

    @Override
    public void insert(E element) {

        if (getCurrentSize() == getHeapSize()) {
            if (getComparator().compare(element, getTop()) > 0) {
                getHeapElements().set(0, element);
                percolateDown(0);
            }
        } else {
            getHeapElements().add(element);
            percolateUp(getCurrentSize());
            setCurrentSize(getCurrentSize() + 1);
        }
    }
}
