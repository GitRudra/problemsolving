package org.home.ds.array;

public class SequenceFinder {

    public static void main(String[] args) {
        SequenceFinder finder = new SequenceFinder();
        int[] input = {1,2,1};
        finder.findBeautifulSequence(input);
    }

    public void findBeautifulSequence(int[] input){
        boolean isNonDecreasing = true;
        boolean isDecreasing = true;
        for(int i=0;i<input.length;i++){
            int j=i;
            for(;j<input.length-1 && isNonDecreasing;j++){
                if(input[j]<=input[j+1]){
                    isNonDecreasing = true;
                }else{
                    isNonDecreasing = false;
                }
            }
            for(;j<input.length-1 && isDecreasing;j++){
                if(input[j]>input[j+1]){
                    isDecreasing = true;
                }else{
                    isDecreasing = false;
                }
            }
            if(!isDecreasing && !isNonDecreasing){
                System.out.println("Found");
                isDecreasing = true;
                isNonDecreasing = true;
            }
        }
    }
}
