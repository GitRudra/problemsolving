package org.home.algo.string;

import java.util.HashMap;

public class ParenthesesMatcher {
    private HashMap<Character, Integer> map;

    public ParenthesesMatcher() {
        map = new HashMap<>();
        populateMap();
    }

    private void populateMap(){
        map.put('(',1);
        map.put(')',-1);
       /* map.put('{',2);
        map.put('}',-2);
        map.put('[',3);
        map.put(']',-3);*/
    }

    public boolean matchParentheses(String input){
        int sum = 0;
        int weight=0;
        for(int i=0;i<input.length();i++){
            weight = map.get(new Character(input.charAt(i)));
            if(sum == 0 && weight == -1){
                return false;
            }else{
                sum+=weight;
            }
        }

        return sum==0;
    }
}
