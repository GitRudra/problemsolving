package org.home.hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        LinkedList<Integer>[] seqList= new LinkedList[n];
        for(int i=0;i<n;i++){
            seqList[i] = new LinkedList<>();
        }
        int lastAnswer = 0;
        List<Integer> lastAnswerList = new ArrayList<>();
        for(List<Integer> list:queries){
            if(list.get(0)==1){
                executeQueryTypeOne(list.get(1),list.get(2),lastAnswer, n,seqList);
            }else if(list.get(0) == 2){
                lastAnswer = executeQueryTypeTwo(list.get(1),list.get(2),lastAnswer, n,seqList);
                //System.out.println(lastAnswer);
                lastAnswerList.add(lastAnswer);
            }
        }
        return lastAnswerList;

    }

    private static void executeQueryTypeOne(int x, int y, int lastAnswer, int SIZE, LinkedList<Integer>[] seqList ){
        int index = (x^lastAnswer)%SIZE;
        seqList[index].addLast(y);
    }

    private static int executeQueryTypeTwo(int x, int y, int lastAnswer, int SIZE, LinkedList<Integer>[] seqList){
        int index = (x^lastAnswer)%SIZE;
        return seqList[index].get(y%seqList[index].size());
    }
}
