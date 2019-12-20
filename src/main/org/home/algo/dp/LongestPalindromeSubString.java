package org.home.algo.dp;

public class LongestPalindromeSubString {
    public static int findLongestPalindromeSubStringRec(String str){
        if(str == null || str.length()==0){
            return -1;
        }
        return findLongestPalindromeSubStringRecUtil(str,0,str.length()-1);
    }

    private static int findLongestPalindromeSubStringRecUtil(String str, int start, int end){
        if(start == end){
            return 1;
        }
        if(str.charAt(start) == str.charAt(end) && start+1==end){
            return 2;
        }
        if(str.charAt(start) != str.charAt(end)){
            return Math.max(findLongestPalindromeSubStringRecUtil(str, start+1,end),
                    findLongestPalindromeSubStringRecUtil(str,start,end-1));
        }else{
            return findLongestPalindromeSubStringRecUtil(str,start+1,end-1)+2;
        }
    }

    public static int findLongestPalindromeSubStringDP(String str){
        return 0;
    }
}
