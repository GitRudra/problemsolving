package org.home.ds.sort;

import java.util.Arrays;

public class Sort {

    public void insertionSort(int[] input){
        int numberOfSwap = 0;
        if(input == null || input.length==0){
            return;
        }
        for(int i=0;i<input.length;i++){
            for(int j=i;j>0;j--){
                if(input[j]<input[j-1]){
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                    numberOfSwap++;
                }
            }
        }
        System.out.println("Total Number of swap : " + numberOfSwap);
    }

    public void mergeSort(int[] input){


    }

    private void mergeSortUtil(int[] input, int start, int end){
        if(end==start){
            return;
        }
        int mid  = (start+end)/2;
        mergeSortUtil(input,start,mid);
        mergeSortUtil(input,mid+1,end);

    }

    private void merge(int[] input, int start, int end, int mid){

    }


    public void quickSort(int[] input){
        if(input==null || input.length==0){
            return;
        }
        quickSortRec(input,0,input.length-1);
    }


    private void quickSortRec(int[] input, int start, int end){
        /**
         * This check the boundary condition if start index is greater that end then return.
         */
        if(start>end){
            return;
        }
        // If the there are two elements in the sub array then just do normal comparison.
        // and if required swap
        if(end-start==1){
            if(input[start]>input[end]){
                swap(input,start,end);
            }
            return;
        }
        //Partition the array into two half based on pivot.
        int p = doQuickPartition(input,start,end);
        //System.out.println("\nPivot found at postion : "+p);
        quickSortRec(input,start,p-1);
        quickSortRec(input,p+1,end);

    }

    private int doQuickPartition(int[] input, int start, int end){
        //System.out.println("\nEntered into partion method with start = "+start+"  end = "+end);
        int pivotElmn = input[start];
        int s =start+1;
        int e  = end;
        if(s==e){
            if(input[start]>input[end]){
                swap(input,start,end);
            }
        }else {
            while (s < e) {
                while (s <= e && input[s] < pivotElmn) {
                    s++;
                }
                while (e >= start && input[e] > pivotElmn) {
                    e--;
                }
                if (s < e) {
                    //System.out.println("\nSwapping " + input[s] + "  " + input[e]);
                    swap(input, s, e);
                }
            }
            //System.out.println("\nSwapping " + input[start] + "  " + input[e]);
            swap(input, start, e);
           // printArray(input);
        }
        return e;
    }

    private void printArray(int[] a){
        Arrays.stream(a).forEach(x-> System.out.print(x+" "));
    }

    private void swap(int[]a, int x, int y){
        int t= a[x];
        a[x] = a[y];
        a[y] = t;
    }


}
