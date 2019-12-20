package org.home.algo.misc;

import java.util.HashMap;
import java.util.HashSet;

public class UpsideDownNumbers {

    public boolean isConfusing(int number,
                                    HashSet<Integer> nonConfusingDigits,
                                    HashMap<Integer, Integer> confusingDigits){

        int temp;
        int num = 0;
        int x = number;
        while(x>0){
            temp = x%10;
            if(nonConfusingDigits.contains(temp)){
                return false;
            }
            if(confusingDigits.containsKey(temp)){
                num = num*10+confusingDigits.get(temp);
            }else{
                num = num * 10 + temp;
            }
            x= x/10;
        }
        return num == number ? false : true;
    }
}
