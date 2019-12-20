package org.home.hackerearth;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MonkAndPowerOfTime {

    public static int executionTime(Integer[] callingOrder, Integer[] idealOrder){
        if(callingOrder == null || callingOrder.length ==0 ||
           idealOrder == null || idealOrder.length == 0){
            return -1;
        }

        Queue<Integer> processCallingOrderQueue = new ArrayDeque<>();
        //processCallingOrderQueue.addAll(callingOrder);
        Arrays.stream(callingOrder).forEach(e->processCallingOrderQueue.add(e));
        int processExecutionTimeCount = 0;
        int idealOrderIndex = 0;
        while(!processCallingOrderQueue.isEmpty()){
            if(!processCallingOrderQueue.peek().equals(idealOrder[idealOrderIndex])){
                processCallingOrderQueue.add(processCallingOrderQueue.peek());
                processCallingOrderQueue.poll();
                processExecutionTimeCount++;
            }else{
                processCallingOrderQueue.poll();
                processExecutionTimeCount++;
                idealOrderIndex++;
            }
        }
        return processExecutionTimeCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queueLength = Integer.parseInt(sc.nextLine());
        Integer[] callingOrder;
        Integer[] idealOrder;

        callingOrder = Arrays.stream(sc.nextLine().split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);
        idealOrder  = Pattern.compile("\\s").splitAsStream(sc.nextLine()).map(Integer::parseInt).toArray(Integer[]::new);

        int time = executionTime(callingOrder,idealOrder);
        System.out.println(time);
        sc.close();

    }
}
