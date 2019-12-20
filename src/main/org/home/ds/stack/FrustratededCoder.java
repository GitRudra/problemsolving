package org.home.ds.stack;

import java.util.*;

public class FrustratededCoder {

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int coderCount = s.nextInt();                 // Reading input from STDIN
        int[] skillSet = new int[coderCount];
        /*for(int i=0;i<coderCount;i++){
            skillSet[i] = s.nextInt();
        }*/
        //System.out.println(getMinimumSum(skillSet,coderCount));
        System.out.println(getSurvivlCount(s,coderCount));
        s.close();
    }

    public static int getMinimumSum(int[] skillSet, int coderCount){
        Arrays.sort(skillSet);
        Queue<Integer> coderStack = new PriorityQueue<>();
        coderStack.add(skillSet[0]);
        int sum =0;
        System.out.println("Fir "+skillSet[0]);
        for(int i=1;i<coderCount;i++){
            if(!coderStack.isEmpty()){
                if(coderStack.peek()<skillSet[i]){
                    coderStack.remove();
                    coderStack.add(skillSet[i]);
                }else{
                    coderStack.add(skillSet[i]);
                }

            }else{
                coderStack.add(skillSet[i]);
            }
        }

        while(!coderStack.isEmpty()){
            sum+=coderStack.remove();
        }
        return sum;
    }

    public static int getSurvivlCount(Scanner sc, int coderCount){
        int[] buletCount = new int[1001];
        int[] targetCount = new int[1001];
        int x;
        for(int i=0;i<coderCount;i++){
            x = sc.nextInt();
            buletCount[x]++;
            targetCount[x]++;
        }
        for(int i=1;i<1001;i++){
            for(int j=i-1;j>=0;j--){
                if(buletCount[i]>0 && targetCount[j]>0){
                    x = Math.min(buletCount[i],targetCount[j]);
                    buletCount[i] -=x;
                    targetCount[j] -=x;
                }
               // buletCount[j] = buletCount[j]-Math.min(buletCount[i],buletCount[j]);
            }
        }

        int sum = 0;
        for(int i=0;i<1001;i++){
            sum+=i*buletCount[i];
        }
        return sum;
    }
}
