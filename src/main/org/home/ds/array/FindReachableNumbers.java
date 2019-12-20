package org.home.ds.array;

public class FindReachableNumbers {

    public int[] findReachableNumbers(int[] inputArray,int starPos,int d1, int d2){
        if(inputArray==null || inputArray.length==0){
            return null;
        }
        int gcd = calculateGcd(d1,d2);
        int[] result = new int[inputArray.length];
        if(gcd==0){
            return result;
        }
        for(int i=0;i<inputArray.length;i++){
            if((inputArray[i]-starPos)%gcd==0){
                result[i]=1;
            }else{
                result[i]=0;
            }
        }
        return  result;
    }

    public int calculateGcd(int x, int y){
        if(x==0 && y==0){
            return 0;
        }else if(x==0){
            return y;
        }else if(y==0){
            return x;
        }else{
            int gcd=0;
            while(y!=0){
                gcd = x%y;
                x=y;
                y=gcd;
            }
            return x;
        }

    }
}
