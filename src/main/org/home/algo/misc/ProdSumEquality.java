package org.home.algo.misc;

public class ProdSumEquality {

    public static void getPairs(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i*j == i+j){
                    System.out.println(i+" , "+j);
                }
            }
        }
    }
}
