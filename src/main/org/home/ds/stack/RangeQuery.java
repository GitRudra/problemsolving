package org.home.ds.stack;

import java.util.Stack;

public class RangeQuery {
    //public Stack<Integer> elements;

    public int findMaxQueryLength(String input){
        if(input == null || input.length()==0){
            return 0;
        }else{//())())()()
            int maxLength = Integer.MIN_VALUE;
            int length = 0;
            Stack<Character> elements = new Stack<>();
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)=='('){
                    elements.push(input.charAt(i));
                }else if(input.charAt(i) == ')'){
                    if(elements.isEmpty()){
                        maxLength = (length>maxLength)?length:maxLength;
                        length = 0;
                    }else{
                        elements.pop();
                        length+=2;
                    }

                }
            }
            maxLength = (length>maxLength)?length:maxLength;
            return maxLength;
        }

    }
}
