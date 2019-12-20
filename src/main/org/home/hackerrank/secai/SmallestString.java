package org.home.hackerrank.secai;

public class SmallestString {
    //static long[] weights = new long[26];

    public static String smallestString(long weight){
        StringBuffer sb = new StringBuffer();
        long[] weights = createWeights();
        while(weight>0){
            char c = getMaxCharacter(weight, weights);
            sb.append(c);
            weight = weight-weights[c-'A'];
        }
        return sb.reverse().toString();
    }

    private static long[] createWeights(){
        long[] weights = new long[26];
        weights[0] = 1;
        for(int i=1;i<26;i++){
            weights[i] = ((i+1) +1)* weights[i-1];
        }
        return weights;
    }

    private static char getMaxCharacter(long x, long[] weights){
        for(int i=0;i<26;i++){
            if(weights[i]>x){
                return (char)('A'+(i-1));
            }
        }
        return 'a';
    }

}
