package org.home.algo.misc;

public class ProblemSolver {

    public int findAngleBetweenHourAndMinuteHand(int hour, int min){
        double hourAngle = hour*30+(min%60)*30/60;
        double minuteAngle = (min%60)*6;
        int difference = (int) Math.floor(Math.abs((hourAngle-minuteAngle)));
        return (difference<180) ? difference : (360-difference);
    }

    public int[] countNumberOfEvenNumbers(String input){
        if(input==null || input.length()==0){
            return null;
        }
        int[] result = new int[input.length()];
        int evenCountSoFar = 0;

        for(int i=input.length()-1;i>=0;i--){
            if(Integer.parseInt(String.valueOf(input.charAt(i)))%2==0){
                evenCountSoFar++;
            }
            result[i] = evenCountSoFar;
        }
        return result;
    }
}
