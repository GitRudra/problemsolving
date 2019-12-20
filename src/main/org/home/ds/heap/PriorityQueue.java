package org.home.ds.heap;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Implementation of priority queue based on heap
 * @param <E>
 */
public class PriorityQueue<E> {
    //Store the heap elements
    private ArrayList<E> heapElements;

    //Maximum size of the heap
    //private int heapSize;

    //Current number of elements in the heap
    private int currentSize;

    //Key property of the heap which decides the behaviour of
    //max or mean heap.
    private Comparator comparator;

    /**
     * Constructor of the heap
     *
     * @param heapSize
     * @param comp
     */
    public PriorityQueue(Comparator comp) {
//        this.heapSize = heapSize;
        this.comparator = comp;
        heapElements = new ArrayList<>();
        currentSize = 0;
    }

    public ArrayList<E> getHeapElements() {
        return heapElements;
    }

    public void setHeapElements(ArrayList<E> heapElements) {
        this.heapElements = heapElements;
    }

    /*public int getHeapSize() {
        return heapSize;
    }*/
    /*public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }*/

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * (i + 1);
    }

    /**
     * Insert the element into the heap.
     * if heap is already full it will throw exception
     * The method insert the new element into the end of the heap and call
     * {@link Heap#percolateUp(int)} for heapify.
     *
     * @param element value to be inserted into heap
     * @throws Exception if heap is full
     */
    public void insert(E element) throws Exception {
        /*if (currentSize == heapSize) {
            throw new Exception("Heap is full !!!");
        } else {*/
            heapElements.add(element);
            percolateUp(currentSize);
            currentSize++;
        //}
    }

    public E getTop() {
        return heapElements.get(0);
    }

    /**
     * Remove the top element from the heap.
     * Copy the end element into top and remove that element.
     * Next it calls {@link Heap#percolateDown(int)} to
     * maintain heap property.
     *
     * @return the top element
     * @throws Exception if the heap is empty
     */
    public E removeTop() throws Exception {
        if (currentSize == 0) {
            throw new Exception("Heap is empty");
        }
        E top = heapElements.get(0);
        currentSize--;
        heapElements.set(0, heapElements.get(currentSize));
        heapElements.remove(currentSize);
        percolateDown(0);
        return top;
    }

    private int minChild(int pos) {
        if (right(pos) >= currentSize) {
            return left(pos);
        }
        if (comparator.compare(heapElements.get(left(pos)),
                heapElements.get(right(pos))) < 0) {
            return left(pos);
        } else {
            return right(pos);
        }
    }

    protected void percolateUp(int pos) {
        //The flag is to control loop execution.
        //If there are no swap then it guarantee heap property.
        boolean swapped = true;
        while (parent(pos) >= 0 && swapped) {
            if (comparator.compare(heapElements.get(pos),
                    heapElements.get(parent(pos))) < 0) {
                swap(pos, parent(pos));
            } else {
                swapped = false;
            }
            pos = parent(pos);
        }
    }

    protected void percolateDown(int pos) {
        while (left(pos) < currentSize) {
            int minChildIndex = minChild(pos);
            if (comparator.compare(heapElements.get(pos),
                    heapElements.get(minChildIndex)) > 0) {
                swap(pos, minChildIndex);
            }
            pos = minChildIndex;
        }

    }

    private void swap(int source, int dest) {
        E temp = heapElements.get(source);
        heapElements.set(source, heapElements.get(dest));
        heapElements.set(dest, temp);
    }

    public int size() {
        return currentSize;
    }
}
