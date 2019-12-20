package org.home.ds.stack;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class GrowableStackTest {

    @Test
    public void testGrowableStackOne() {
        GrowableStack<Integer> gStack= new GrowableStack<Integer>(20);
        for(int i=0;i<100;i++){
            gStack.push(i);
        }
        Integer lastElement = gStack.pop();
        System.out.println(lastElement);
        gStack.printStackStat();
    }

    @Test
    public void testGrowableStackTwo() {
        GrowableStack<Integer> gStack= new GrowableStack<Integer>(2);
        for(int i=0;i<5;i++){
            gStack.push(i);
        }
        gStack.printStackStat();
        gStack.pop();
        gStack.printStackStat();
        gStack.pop();
        gStack.printStackStat();
    }

    @Test(expected = EmptyStackException.class)
    public void testPopInEmptyStack() {
        GrowableStack<Integer> gStack= new GrowableStack<Integer>(2);

        gStack.printStackStat();
        gStack.pop();
        gStack.pop();
        gStack.printStackStat();
    }
}