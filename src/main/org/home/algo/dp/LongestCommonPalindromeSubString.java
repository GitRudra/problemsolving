package org.home.algo.dp;

public class LongestCommonPalindromeSubString {

    public static String findLongestCommonPalindromeString(String inputStr){
        if(inputStr == null || inputStr.length() == 0){
            return "";
        }
        if(inputStr.length() == 1){
            return inputStr;
        }

        int len = inputStr.length();

        boolean[][] lcps = new boolean[len][len];

        //Case:1 Sub Sequence length = 1
        /*for(int i=0;i<len;i++){
            lcps[i][i] = 1;
        }*/

        //Sub sequence length
        /*int sl = 2;
        int j=0;
        for(;sl<=len;sl++){
            for(int i=0;i<len-sl+1;i++){
                j = i+sl-1;
                if(inputStr.charAt(i) == inputStr.charAt(j)){
                    if(sl==2){
                        lcps[i][j] = 2;
                    }else{
                        lcps[i][j] = lcps[i+1][j-1]+2;
                    }
                }else{
                    lcps[i][j] = Math.max(lcps[i+1][j],lcps[i][j-1]);
                }
            }
        }*/
        //return lcps[0][len-1];
        return "";
    }
}
