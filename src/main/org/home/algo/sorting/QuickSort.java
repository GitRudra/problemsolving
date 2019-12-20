package org.home.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort<E> {

    private int getPartitionIndex(int start, int end){
        return start;
    }

    public void quickSort(ArrayList<E> elements, Comparator comp){
        if(elements == null || elements.isEmpty()){
            return;
        }
        quickSortUtil(elements,0,elements.size()-1,comp);
    }
    private void quickSortUtil(ArrayList<E> elements, int start, int end, Comparator comp){
        if(start>end){
            return;
        }

        int pivot = getPartitionIndex(start,end);
        int s = start+1;
        int e = end;

        //{2,4,6,8,9,7,5,3,1,11}
        while(s<=e){
            while(comp.compare(elements.get(pivot),elements.get(s)) > 0){
                s++;
            }
            while(comp.compare(elements.get(pivot),elements.get(e)) < 0){
                e--;
            }

            if(s<e){
                swap(elements,s,e);
            }

        }
        if(e<s){
            swap(elements,pivot,e);
            quickSortUtil(elements,start,e-1,comp);
            quickSortUtil(elements,e+1,end,comp);
        }
    }

    private void swap(ArrayList<E> elements, int i, int j){
        E temp = elements.get(i);
        elements.set(i,elements.get(j));
        elements.set(j,temp);
    }


}
