package org.home.algo.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationToString {
    HashMap<String,String> numberStringMap;
    List<String> words;
    private void populateMap(){
        numberStringMap = new HashMap<>();
        numberStringMap.put("1","");
        numberStringMap.put("2","abc");
        numberStringMap.put("3","def");
        numberStringMap.put("4","ghi");
        numberStringMap.put("5","jkl");
        numberStringMap.put("6","mno");
        numberStringMap.put("7","pqrs");
        numberStringMap.put("8","tuv");
        numberStringMap.put("9","wxyz");
        numberStringMap.put("0","");
        words = new ArrayList<>();
    }
    public List<String> letterCombinations(String digits) {
         populateMap();
         if(digits == null || digits.length()==0){
             return Collections.emptyList();
         }
         //populateMap();
         letterCombinationsUtil(digits,"",0);
         return words;
    }

    private void letterCombinationsUtil(String digits,String word,int index){
        if(index>=digits.length()){
            words.add(word);
            return;
        }
        String mapCharacters = numberStringMap.get(String.valueOf(digits.charAt(index)));
        for(int i = 0;i<mapCharacters.length();i++){
            letterCombinationsUtil(digits,word+String.valueOf(mapCharacters.charAt(i)),index+1);
        }
    }
}
