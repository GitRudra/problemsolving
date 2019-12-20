package org.home.ds.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumStackTest {

    @Test
    public void add() {
		MinimumStack stack = new MinimumStack();
		stack.add(10);
    }

    @Test
    public void findMin() {
		MinimumStack stack = new MinimumStack();
		stack.add(10);
		stack.add(11);
		stack.add(9);
		stack.add(10);
		stack.add(14);
		Integer actual  = stack.findMin();
		Integer expected = 9;
        System.out.println("Actual  = "+ actual);
		assertEquals(expected, actual);
		stack.pop();
        stack.pop();
        stack.pop();
        actual  = stack.findMin();
        System.out.println("Actual  = "+ actual);
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void findMinoptimized() {
        MinimumStack stack = new MinimumStack();
        int[] inputs = {10,11,9,10,11,9,10,11,9,10,11,9,10,11,9,10,11,9,10,11,9,10,11,9,10,14};
        for(int i=0;i<inputs.length;i++){
            stack.optimizedPush(inputs[i]);
            stack.printStckSize(inputs[i],"Push");
        }
        /*stack.optimizedPush(10);
        stack.printStckSize(10,"Push");
        stack.optimizedPush(11);
        stack.optimizedPush(9);
        stack.optimizedPush(10);
        stack.optimizedPush(14);*/
        Integer actual  = stack.findMin();
        Integer expected = 9;
        System.out.println("Actual  = "+ actual);
        assertEquals(expected, actual);
        stack.optimizedPop();
        stack.printStckSize(null,"Pop");
        stack.optimizedPop();
        stack.printStckSize(null,"Pop");
        stack.optimizedPop();
        stack.printStckSize(null,"Pop");
        actual  = stack.findMin();
        System.out.println("Actual  = "+ actual);
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void pop() {
    }

    @Test
    public void findMinAmongElements() {
    }
}