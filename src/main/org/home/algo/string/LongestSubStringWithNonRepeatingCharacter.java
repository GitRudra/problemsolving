package org.home.algo.string;

import java.util.Arrays;

public class LongestSubStringWithNonRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] frequency = new int[256];
        Arrays.fill(frequency,0);
        int start = 0;
        String maxString = "";
        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(frequency[s.charAt(i)] == 0){
                frequency[s.charAt(i)]++;
            }else{
                if((i-start) > maxLength){
                    maxString  = s.substring(start, i);
                    maxLength = (i-start);
                    start = i;
                }


            }
        }
        return maxString.length();

    }
}
