package org.home.cmp.ms.problems;

public class ProblemSolver {

    public void sort012(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        int twoIndex = input.length - 1;
        int zeroIndex = 0;
        for (int i = 0; i <= twoIndex; i++) {
            if (input[i] == 2) {
                while (input[twoIndex] == 2) {
                    twoIndex--;
                }
                int t = input[twoIndex];
                input[twoIndex] = input[i];
                input[i] = t;
                twoIndex--;
            }
            if (input[i] == 0) {
                /*while (input[zeroIndex] == 0) {
                    zeroIndex++;
                }*/
                int t = input[zeroIndex];
                input[zeroIndex] = input[i];
                input[i] = t;
                zeroIndex++;
            }
        }
    }

    public void sortZeroOneTwo(int[] input){
        
    }
}
