package org.home.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *
 *     All inputs will be in lowercase.
 *     The order of your output does not matter.
 */

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {

        //Arrays.stream(strs).forEach(e-> System.out.println(e+" "+generateHash(e)));
//        Arrays.stream(strs).collect(Collectors.groupingBy(generateHash()))

        Map<String, List<String>> resultMap = new HashMap<>();
        for(String x: strs){
            String key = generateStringHash(x);
            if(resultMap.containsKey(key)){
                resultMap.get(key).add(x);
            }else{
                List<String> l = new ArrayList<>();
                l.add(x);
                resultMap.put(key,l);
            }
        }
        return new ArrayList<>(resultMap.values());
    }

    /*private static int generateHash(String s){
        int h = 0;
        for(int i=0;i<s.length();i++){
            h += (s.charAt(i)-'a')*s.charAt(i) * 31;
        }

        return h;
    }*/

    private static String generateStringHash(String s){
        int h = 0;
        int[] alphabet = new int[26];
        Arrays.fill(alphabet,0);
        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i)-'a']++;
        }
        String key = "";
        for(int i=0;i<26;i++){
            if(alphabet[i]!=0){
                key = key+('a'+i)+alphabet[i];
            }
        }

        return key;
    }
}
