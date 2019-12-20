package org.home.ds.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class GrowableStack<E> {

    private ArrayList<Stack<E>> stackList;
    private Stack<E> currentStack;
    private final Integer STACK_SIZE;

    public GrowableStack(Integer stackSize) {
        this.stackList = new ArrayList<>();
        STACK_SIZE = stackSize;
        Stack temp = new Stack<>();
        stackList.add(temp);
        currentStack = temp;
    }

    public E pop(){

        return specializedPop();
    }

    public void push(E elem){
        specializedPush(elem);
    }

    private void specializedPush(E elem){
        if(currentStack.size() == STACK_SIZE){
            Stack<E> newStack = new Stack<E>();
            stackList.add(newStack);
            this.currentStack = newStack;
        }
        currentStack.push(elem);
    }

    private E specializedPop(){
        if(stackList.isEmpty()){
            throw new EmptyStackException();
        }else{
            if(currentStack.isEmpty()){
                if(stackList.size()==1){
                    throw new EmptyStackException();
                }else{
                    currentStack = stackList.get(stackList.size()-2);
                    stackList.remove(stackList.size()-1);
                    return currentStack.pop();
                }
            }else{
                return currentStack.pop();
            }
        }
    }

    public void printStackStat(){
        System.out.println("----------------------------------");
        System.out.println(" Number of stack : " + stackList.size());
        for(int i=0;i<stackList.size();i++){
            System.out.println(" Elements in Stack-"+(i+1)+" : "+stackList.get(i));
        }
        System.out.println("----------------------------------");
    }
}
