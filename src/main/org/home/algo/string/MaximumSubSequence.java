package org.home.algo.string;

import java.util.List;

/**
 * The Challenge
 *
 * Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
 *
 * Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.
 *
 * Note: D can appear in any format (list, hash table, prefix tree, etc.
 *
 * For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"
 *
 * The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
 *
 * The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.
 *
 * The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.
 */
public class MaximumSubSequence {

    public static boolean isSubSequence(String str, String subSeq){
        if(str ==  null || str.length() == 0 ||
                subSeq == null || subSeq.length() == 0){
            return false;
        }
        int matchCount = 0;
        int len1 = str.length();
        int len2 = subSeq.length();
        int i = 0;
        int j = 0;
        while(i<len1 && j< len2){
            if(str.charAt(i) == subSeq.charAt(j)){
                matchCount++;
                i ++;
                j++;
            }else{
                i++;
            }
        }
        return matchCount == len2;
    }

    public static String findLongestSubSequence(List<String> dictionary, String word){
        if(dictionary == null || dictionary.size() == 0 ||
                word == null || word.length() == 0){
            return null;
        }
        String maxString = "";
        int maxLength = Integer.MIN_VALUE;
        for(String s:dictionary){
            if(isSubSequence(word,s)){
                if(s.length() > maxLength){
                    maxLength = s.length();
                    maxString = s;
                }
            }
        }
        return maxString;
    }

}
