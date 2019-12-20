package org.home.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring,
 *              "pwke" is a subsequence and not a substring.
 */
public class LongestSubStringWithNonRepeatingCharacter {

    public static int lengthOfLongestSubstring(String s) {
        if(s== null || s.length()==0){
            return 0;
        }
        //int count = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(frequencyMap.containsKey(s.charAt(i))){
                if(frequencyMap.size()>maxLength){
                    maxLength = frequencyMap.size();
                }
                int index = frequencyMap.get(s.charAt(i));
                frequencyMap.clear();
                //frequencyMap.put(s.charAt(i),i);
                i=index;
            }else{
                frequencyMap.put(s.charAt(i),i);
            }
        }

        if(frequencyMap.size()>maxLength){
            maxLength = frequencyMap.size();
        }

        return maxLength;
    }
}
