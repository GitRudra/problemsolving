package org.home.ds.stack;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> source;
    private Stack destination;
    public static void main(String[] args) {
        QueueUsingStack qus = new QueueUsingStack();
        qus.add(1);
        qus.add(2);
        qus.add(3);
        qus.add(4);
        qus.add(5);
        System.out.println(qus.remove());
        System.out.println(qus.remove());
        System.out.println(qus.remove());
        qus.add(6);
        System.out.println(qus.remove());

    }

    public QueueUsingStack(){
        source = new Stack<>();
        destination = new Stack();
    }

    public void add(Integer elem){
        source.add(elem);

    }

    public Integer remove(){
        if(source.isEmpty()){
            return null;
        }else{
            moveElements(source,destination);
            Integer elem = (Integer)destination.pop();
            moveElements(destination,source);
            return  elem;
        }
    }

    private void moveElements(Stack source,Stack destination){
        if(!source.isEmpty()){
            while(!source.isEmpty()){
                destination.push(source.pop());
            }
        }
    }
}
