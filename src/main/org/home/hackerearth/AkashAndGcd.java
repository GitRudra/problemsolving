package org.home.hackerearth;

public class AkashAndGcd {

    private int[] inputArray;
    private int[] gcdSumArray;
    private int[] sumQueryArray;
    private int longMod;

    public AkashAndGcd(int[] inputArray) {
        this.inputArray = inputArray;
        gcdSumArray = new int[inputArray.length];
        sumQueryArray = new int[inputArray.length];
        longMod = (int)Math.pow(10,9)+7;
        preProcess();
    }

    private void preProcess(){
        long start = System.currentTimeMillis();
        System.out.println("Started preparing GCD Sum Array ");
        generateGcdSumArray();
        long end = System.currentTimeMillis();
        System.out.println("Completed preparing GCD Sum Array");
        System.out.println("Time taken : "+ (end-start));
        generateSumQueryArray();

    }

    private void generateGcdSumArray(){
        for(int i=0;i<inputArray.length;i++){
            gcdSumArray[i] = gcdSum(inputArray[i]);
        }
    }

    private void generateSumQueryArray(){
        for(int i=0;i<inputArray.length;i++){
            if(i==0){
                sumQueryArray[i] = gcdSumArray[i];
            }else{
                sumQueryArray[i] = gcdSumArray[i]+sumQueryArray[i-1];
            }
        }
    }

    private int gcdSum(int x){
        int gcdSum = 0;
        for(int j=1;j<=x;j++){
            gcdSum += gcd(j,x);
        }
        return gcdSum;
    }

    public int cQuery(int x, int y){
        if((x-1)==0){
            return sumQueryArray[y-1] % longMod;
        }else{
            return (sumQueryArray[y-1]-sumQueryArray[x-2]) % longMod;
        }
    }

    public void uQuery(int index, int value){
        inputArray[index-1] = value;
        gcdSumArray[index-1] = gcdSum(value);
        generateSumQueryArray();
    }

    private int gcd(int x, int y){
        if(y==0){
            return x;
        }
        if(x==0){
            return y;
        }

        int gcd = 0;
        while(y>0){
            gcd = x%y;
            x = y;
            y = gcd;
        }

        return x;
    }


}
