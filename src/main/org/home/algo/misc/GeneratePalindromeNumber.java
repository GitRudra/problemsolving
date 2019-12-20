package org.home.algo.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePalindromeNumber {

    public int generatePalindrome(int n, int base, boolean isOdd){
        int palin = n;
        if(isOdd){
            n = n/base;
        }
        while(n>0){
            palin = palin*base+(n%base);
            n /= base;
        }

        return palin;
    }

    public List<Integer> generatePalindrome(int n){
        List<Integer> numbers = new ArrayList<>();
        for(int j=0;j<2;j++){
            int i=1;
            int number = 0;

            while((number=generatePalindrome(i,10,((j%2)==0)))<n){
                numbers.add(number);
                i++;
            }
        }
        Collections.sort(numbers);
        return numbers;
    }
}
