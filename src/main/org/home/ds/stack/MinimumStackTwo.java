package org.home.ds.stack;

import java.util.Stack;

public class MinimumStackTwo {
    Stack<Integer> elements;
    private Integer minElement;

    public MinimumStackTwo() {
        this.elements = new Stack<>();
        this.minElement = Integer.MAX_VALUE;
    }

    public void push(Integer el){
        if(elements.isEmpty()){
           minElement = el;
           elements.push(el);
        }else{
            if(el>=minElement){
                elements.push(el);
            }else{
                elements.push(2*el-minElement);
                minElement=el;
            }
        }
    }

    public Integer pop() throws Exception {
        Integer e = null;
        Integer poppedValue;
        if(elements.isEmpty()){
           throw new Exception("Empty Stack");
        }else{
            e = elements.pop();
            if(e<minElement){
                poppedValue = minElement;
                minElement = 2*minElement-e;
            }else{
                poppedValue = e;
            }
        }
        return poppedValue;
    }

    public Integer getMinElement(){
        return minElement;
    }
}
