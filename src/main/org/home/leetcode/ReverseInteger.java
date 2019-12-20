package org.home.leetcode;

public class ReverseInteger {

    private static int MAX_LIMIT = (int)Math.pow(2,16)-1;
    private static int MIN_LIMIT = -(int)Math.pow(2,16);
    public static int reverse(int x) {
        if(x == 0 || x>MAX_LIMIT || x<MIN_LIMIT){
            return 0;
        }
        int input = Math.abs(x);
        int num = 0;
        while(input!=0){
            num = num*10+(input%10);
            input = input/10;
        }
        if(x<0){
            num = -num;
        }
        return num;

    }
}
