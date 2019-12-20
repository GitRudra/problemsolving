package org.home.ds.stack;

import java.util.List;
import java.util.Stack;

public class MinimumStack {
    private Stack<Integer> elementsStack;
    private Stack<Integer> minStack;

    public MinimumStack() {
        elementsStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void printStckSize(Integer elem, String op){
        System.out.println("Size of element stack after " + elem+" ["+ op+"] : "+elementsStack.size());
        System.out.println("Size of min stack after " + elem+" ["+ op+"] : "+minStack.size());
    }

    public void add(Integer elem){
        elementsStack.push(elem);
        if(minStack.isEmpty()){
            minStack.push(elem);
        }else{
            if(minStack.peek()<= elem){
                minStack.push(minStack.peek());
            }else{
                minStack.push(elem);
            }
        }
    }

    public void optimizedPush(Integer elem){
        elementsStack.push(elem);
        if(minStack.isEmpty()){
            minStack.push(elem);
        }else{
            if(minStack.peek()> elem){
                minStack.push(elem);
            }
        }
    }

    public Integer findMin(){
        return minStack.peek();
    }

    public Integer pop(){
        if(elementsStack.isEmpty()){
            return  null;
        }else{
            minStack.pop();
            return elementsStack.pop();
        }
    }

    public Integer optimizedPop(){
        if(elementsStack.isEmpty()){
            return  null;
        }else{
            if(elementsStack.peek()== minStack.peek()){
                minStack.pop();
            }
            return elementsStack.pop();
        }
    }

    public Integer findMinAmongElements(List<Integer> elements){
        return  null;
    }
}
