package org.home.algo.dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    class Result{
        int length;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

    public Result calculateLis(int[] input) throws Exception {
        if(input==null || input.length==0){
            throw new Exception("Invalid Argument !!!");
        }
        int max_length=1;
        int max_length_pos=0;
        if(input.length==1){
            max_length=1;
            max_length_pos = 0;
        }else{
            int lis[] = new int[input.length];
            Arrays.fill(lis,1);
            for(int i=0;i<input.length;i++){
                for(int j=0;j<i;j++){
                    if(input[j]<=input[i]){
                        lis[i] = Math.max(lis[i],lis[j]+1);
                    }
                    if(max_length<lis[i]){
                        max_length = lis[i];
                        max_length_pos = i;
                    }
                }
            }

            int[] participatingElements = new int[max_length];
            int k=max_length-1;
            participatingElements[k] = input[max_length_pos];
            for(int j=max_length_pos;j>=0;j--){
                
            }
        }
        Result result = new Result();
        result.setLength(max_length);
        return result;
    }

}
