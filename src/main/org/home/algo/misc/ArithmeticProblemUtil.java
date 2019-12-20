package org.home.algo.misc;

public class ArithmeticProblemUtil {

    public static int calculatePow(int x,int y){
        if(y==0){
            return 1;
        }else{
            if(y%2==0){
                return calculatePow(x,y/2)*calculatePow(x,y/2);
            }else{
                return x*calculatePow(x,y/2)*calculatePow(x,y/2);
            }
        }
    }

    public static int calculatePowOptimized(int x,int y){
        if(y==0){
            return 1;
        }else{
            int temp = calculatePow(x,y/2);
            if(y%2==0){
                return temp*temp;
            }else{
                return x*temp*temp;
            }
        }
    }
}
