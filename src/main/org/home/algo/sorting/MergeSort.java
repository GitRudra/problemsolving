package org.home.algo.sorting;

public class MergeSort {

    //Merge two array keeping sorted order
    public void merge(int[] a, int start, int mid, int end){
        int i = start;
        int j = mid+1;
        int k=0;
        int[] sortedMerged = new int[end-start+1];
        while(i<=mid && j<=end){
            if(a[i] <= a[j]){
                sortedMerged[k] = a[i];
                i++;
                k++;
            }else{
                sortedMerged[k] = a[j];
                j++;
                k++;
            }
        }
        //check whether any element remaining in right side.
        if((i-1)==mid && j<=end){
            while(j<=end){
                sortedMerged[k] = a[j];
                j++;
                k++;
            }
        }

        //Check whether any element remaining in left side
        if((j-1)==end && i<=mid){
            while(i<=mid){
                sortedMerged[k] = a[i];
                i++;
                k++;
            }
        }

        //replace the sorted array in the actual array
        for(int l=start;l<=end;l++){
            a[l] = sortedMerged[l-start];
        }
    }

    //Method to sort the elements.
    public void sort(int[] a, int start, int end){
        if(start>=end){
            return;
        }
        int mid = (end+start)/2;
        sort(a,start,mid);
        sort(a,mid+1,end);
        merge(a,start,mid,end);
    }

    //Method to sort elements which take care of boundary conditions.
    public void mergeSort(int[] a) throws Exception {
        if(a==null||a.length==0){
            throw new Exception("Invalid input");
        }
        if(a.length==1){
            return;
        }

        sort(a,0,a.length-1);
    }
}
