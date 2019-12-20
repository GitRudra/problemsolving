package org.home.ds.sort;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * Constraints : Need to sort the numbers in one pass of the array
 *
 * Examples:
 *
 * Input :  {0, 1, 2, 0, 1, 2}
 * Output : {0, 0, 1, 1, 2, 2}
 *
 * Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 * Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class DutchNationalFlagProblem {

    /**
     * The problem was posed with three colours, here `0', `1' and `2'.
     * The array is divided into four sections:
     * <li>
     *     <ul>a[1..Lo-1] zeroes (red)</ul>
     *     <ul>a[Lo..Mid-] ones (white)</ul>
     *     <ul>a[Mid..Hi] unknown</ul>
     *     <ul>a[Hi+1..N] twos (blue)</ul>
     * </li>
     *
     * The unknown region is shrunk while maintaining these conditions
     *   Lo := 1; Mid := 1; Hi := N;
     *   while Mid <= Hi do
     *     Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
     *     case a[Mid] in
     *       0: swap a[Lo] and a[Mid]; Lo++; Mid++
     *       1: Mid++
     *       2: swap a[Mid] and a[Hi]; Hi--
     * @param input
     */
    public void sort(int[] input){
        if(input == null || input.length == 0){
            return;
        }
        int low = 0;
        int mid = 0;
        int high = input.length-1;
        while(mid<=high){
            if(input[mid]==0){
                swap(input,low,mid);
                low++;
                mid++;
            }else if(input[mid] == 1){
                mid++;
            }else{
                swap(input,mid,high);
                high--;
            }
        }
    }

    private void swap(int[] input, int source, int destination){
        int t = input[source];
        input[source] = input[destination];
        input[destination] = t;
    }
}
