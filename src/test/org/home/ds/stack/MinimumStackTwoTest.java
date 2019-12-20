package org.home.ds.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumStackTwoTest {

    @Test
    public void push() {
    }

    @Test
    public void pop() {
    }

    @Test
    public void getMinElement() {
    }

    @Test
    public void checkMinmumStackOne() throws Exception {
        MinimumStackTwo stack2 = new MinimumStackTwo();
        stack2.push(2);
        stack2.push(11);
        stack2.push(3);
        stack2.push(5);
        stack2.push(4);
        stack2.push(8);
        System.out.println(stack2.getMinElement());
        System.out.println("Popped Element : "+stack2.pop());
        System.out.println(stack2.getMinElement());
    }

    @Test
    public void checkMinmumStackTwo() throws Exception {
        MinimumStackTwo stack2 = new MinimumStackTwo();
        for(int i=10;i>0;i--){
            stack2.push(i);
        }

        for(int i=0;i<10;i++){
            System.out.println("Minimum Element : "+stack2.getMinElement());
            System.out.println("Popped Element : "+stack2.pop());
        }
    }
}