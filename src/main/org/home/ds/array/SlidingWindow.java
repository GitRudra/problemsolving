package org.home.ds.array;

import java.util.*;

public class SlidingWindow {

    public static List<Integer> findNegativeIntegersInSubArrayOfSizeK(int[] input, int k) throws Exception {
        if(input==null || input.length==0 || input.length <k){
            throw new Exception("Invalid input exception");
        }
        List<Integer> result = new ArrayList();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int i= 0;
        for(i=0;i<k;i++){
            if(input[i]<0){
                dq.addLast(i);
            }
        }
        for(;i<input.length;i++){
            if(!dq.isEmpty()){
                result.add(input[dq.getFirst()]);
            }else{
                result.add(0);
            }

            /*while(!dq.isEmpty() && dq.getFirst()<i-k+1){
                int x = dq.removeFirst();
                System.out.println("In While loop "+ x+ " i = "+i);
            }*/
            if(!dq.isEmpty() && dq.getFirst()<i-k+1){
                dq.removeFirst();
            }
            if(input[i]<0){
                dq.addLast(i);
            }
        }

        if(!dq.isEmpty()){
            result.add(input[dq.getFirst()]);
        }else{
            result.add(0);
        }

        return result;
    }


    /**
     * We create a Deque, Qi of capacity k, that stores only useful elements of
     * current window of k elements. An element is useful if it is in current window
     * and is greater than all other elements on left side of it in current window.
     * We process all array elements one by one and maintain Qi to contain useful
     * elements of current window and these useful elements are maintained in sorted order.
     * The element at front of the Qi is the largest and element at rear of Qi is the
     * smallest of current window.
     * @param input
     * @param k
     * @return
     * @throws Exception
     */
    public static List<Integer> findMaximumInEachSubArrayOfSizeK(int[] input, int k) throws Exception {
        if(input==null || input.length==0 || k<=0 || input.length<k){
            throw new Exception("Invalid Argument !!!");
        }

        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList();
        int i=0;
        int max = Integer.MIN_VALUE;
        for(;i<k;i++){
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while(!dq.isEmpty() && input[i]>=input[dq.peekLast()]){
                dq.removeLast();
            }

            // Add new element at rear of queue
            dq.addFirst(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for(;i<input.length;i++){

            // The element at the front of the queue is the largest element of
            // previous window, so print it
            result.add(input[dq.peek()]);

            // Remove the elements which are out of this window
            while(!dq.isEmpty() && dq.peek()<=i-k){
                dq.removeFirst();
            }

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!dq.isEmpty()) && input[i] >= input[dq.peekLast()])
                dq.removeLast();


            // Add current element at the rear of Qi
            dq.addLast(i);
        }

        result.add(input[dq.peek()]);

        return result;
    }

    public static int[] findFirstNegativeInteger(int[] input, int k) {
        if (input == null || input.length == 0 || k == 0 || input.length < k) {
            return null;
        }
        int[] result = new int[input.length - k + 1];
        int j = 0;
        ArrayDeque<Integer> dequeue = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (input[i] < 0) {
                dequeue.add(input[i]);
            }
        }
        if (dequeue.isEmpty()) {
            result[j++] = 0;
        } else {
            result[j++] = dequeue.getFirst();
        }

        for (int i = 1; i <= input.length - k; i++) {
            if (input[i + k - 1] < 0) {
                dequeue.add(input[i + k - 1]);
            }
            if (input[i - 1] == dequeue.getFirst()) {
                dequeue.removeFirst();
            }
            if (dequeue.isEmpty()) {
                result[j++] = 0;
            } else {
                result[j++] = dequeue.getFirst();
            }
        }
        return result;

    }

    public int[] findMaximumInEachSubArrayOfSizeKTwo(int[] input, int k) {
        /*ArrayDeque queue = new ArrayDeque();
        int[] result = new int[input.length-k];
        int localMax = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            if(input[i]>localMax){
                localMax = input[i];
            }
        }
        int j= 0;
        queue.add(localMax);
        result[j++] = localMax;
        for(int i=1;i<=input.length-k;i++){
            if()
        }*/
        return null;

    }
}
