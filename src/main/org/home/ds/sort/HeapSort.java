package org.home.ds.sort;

import java.util.Comparator;

public class HeapSort<T> {

    private T[] input;
    private int heapLength;
    private Comparator<T> comperator;
    private int heapSize;

    public HeapSort(Class<T> type, T[] input, Comparator<T> comparator) {
        this.comperator = comparator;
        this.heapLength = input.length;
        this.input = input;
        this.heapSize = heapLength;
    }

    public void printHeap() {
        System.out.println("--------------------------");
        for (int i = 0; i < heapLength; i++) {
            System.out.print(input[i].toString() + "  ");
        }
    }

    private int getParent(int i) {
        return i / 2;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * (i + 1);
    }

    private void swap(int source, int destination) {
        T temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }

    private void buildHeap(){
        for (int i = heapLength /2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int index){
        int small;
        int left = getLeft(index);
        int right = getRight(index);
        if (left <= heapLength && comperator.compare(input[left], input[index]) < 0) {
            small = left;
        } else {
            small = index;
        }

        if (right <= heapLength && comperator.compare(input[right], input[small]) < 0) {
            small = right;
        }
        if (small != index) {
            swap(index, small);
            heapify(small);
        }
    }


    public void sort(){
        buildHeap();
        for(int i = heapLength -1; i>0; i--){
            swap(0,i);
            heapSize--;
            heapify(0);
        }

    }
}
