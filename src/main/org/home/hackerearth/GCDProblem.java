package org.home.hackerearth;

import java.util.Arrays;

public class GCDProblem {

    private int[][] gcdArray;
    private int max_range;
    private int[] inputArray;

    public GCDProblem(int[] inputArray) {
        this.inputArray = inputArray;
        this.max_range = findMax();
        gcdArray = new int[max_range+1][max_range+1];
        for(int i=0;i<max_range+1;i++){
            Arrays.fill(gcdArray[i],0);
        }
        generateGcdTable();

    }

    private int findMax(){
        int max = Integer.MIN_VALUE;
        for(int x:inputArray){
            if(x>max){
                max=x;
            }
        }
        return max;
    }

    private void generateGcdTable(){
        long start = System.currentTimeMillis();
        System.out.println("Started preparing GCD Sum Array ");
        for(int i=1;i<=max_range;i++){
            for(int j=1;j<=max_range;j++){
                gcdArray[i][j] = gcd(i,j);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Completed preparing GCD Sum Array");
    }

    public int getGcd(int x, int y){
        return gcdArray[x][y];
    }

    public int gcd(int x, int y){
        if(y==0){
            return x;
        }else if(gcdArray[x][y] != 0){
            return gcdArray[x][y];
        }else{
            return gcd(y,x%y);
        }
    }

    public void printGcdArray(){
        for(int i=0;i<=max_range;i++){
            System.out.println("");
            for(int j=0;j<=max_range;j++){
                System.out.print(gcdArray[i][j]+ " ");
            }
        }
    }

    public int getGcdSum(int x){
        int gcdSum = 0;
        for(int i=1;i<=x;i++){
            gcdSum += getGcd(i,x);
        }
        return gcdSum;
    }

}
