package org.home.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamiltonianAndLagrangian {
    public static void main(String[] args) {
        //Scanner
        Scanner s = new Scanner(System.in);
        /*String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");*/    // Writing output to STDOUT
        int inputSize = s.nextInt();
        int[] input = new int[inputSize];
        for(int i=0;i<inputSize;i++){
            input[i] = s.nextInt();
        }

        HamiltonianAndLagrangian solver = new HamiltonianAndLagrangian();
        solver.findNumbers2(input);
    }

    public int[] findNumbers(int[] input){
        if(input==null || input.length==0){
            return null;
        }
        List<Integer> result = new ArrayList();
        int inputLength = input.length;
        int maxSoFar = input[inputLength-1];
        result.add(input[inputLength-1]);
        for(int i=inputLength-2;i>=0;i--){
            if(input[i]>maxSoFar){
                maxSoFar = input[i];
                result.add(input[i]);
            }
        }
        int[] output = new int[result.size()];
        for(int k=0;k<result.size();k++){
            output[result.size()-1-k] = result.get(k);
        }
        return  output;
    }

    public void findNumbers2(int[] input){
        if(input==null || input.length==0){

        }else{
            int inputLength = input.length;

            int[] output = new int[inputLength];
            int outputCount = 0;
            output[outputCount] = input[inputLength-1];
            outputCount++;
            int maxSoFar = input[inputLength-1];
            for(int i=inputLength-2;i>=0;i--){
                if(input[i]>maxSoFar){
                    maxSoFar = input[i];
                    output[outputCount] = input[i];
                    outputCount++;
                }
            }

            for(int k=outputCount-1;k>0;k--){
                System.out.print(output[k]+" ");
            }
            System.out.print(output[0]);

        }
    }
}
