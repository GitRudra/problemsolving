package org.home.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalidromicDecomposition {

    public static void decomposeString(String s){
        ArrayList<ArrayList<String>> possibleDecomposition = new ArrayList<>();
        ArrayList<String> decompose = new ArrayList<>();
        decomposeStringUtil(s,0,decompose,possibleDecomposition);
        possibleDecomposition.forEach(e-> System.out.println(e));
    }

    private static void decomposeStringUtil(String s,
                                 int curIndex,
                                 ArrayList<String> decompose,
                                 ArrayList<ArrayList<String>> possibleDecomposition){
        if(curIndex == s.length()){
            possibleDecomposition.add(new ArrayList(decompose));
        }else{
            for(int i = curIndex;i<s.length();i++){
                if(isPalindrome(s,curIndex,i)){
                    String prefix = s.substring(curIndex,i+1);
                    decompose.add(prefix);
                    decomposeStringUtil(s,i+1,decompose,possibleDecomposition);
                    decompose.remove(decompose.size()-1);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end){
        if(s == null || s.length() == 0){
            return false;
        }
//        int start = 0;
//        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return  true;
    }
}
