package org.home.ds.list;

import java.util.Collections;
import java.util.LinkedList;

public class AddTwoLargeList {
    public LinkedList addTwoNumbers(LinkedList<Integer> number1, LinkedList<Integer> number2){
       if(number1 == null || number1.size()==0 ){
           return number2;
       }

       if(number2 == null || number2.size()==0){
           return number1;
       }

       int length1 = number1.size();
       int length2 = number2.size();

       if(length1 > length2){

       }
        return null;
    }

}
