package org.home.algo.dp;

/**
 * We have discussed Overlapping Sub-problems and Optimal Substructure properties
 * in Set 1 and Set 2 respectively.
 * We also discussed one example problem in Set 3.
 * Let us discuss Longest Common Subsequence (LCS) problem as one more example
 * problem that can be solved using Dynamic Programming.
 *
 * LCS Problem Statement: Given two sequences, find the length of longest sub-sequence
 * present in both of them. A subsequence is a sequence that appears in the same
 * relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc
 * are subsequences of “abcdefg”.
 * So a string of length n has 2^n-1 different possible subsequences.
 *
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *
 * It is a classic computer science problem,
 * the basis of diff (a file comparison program that outputs
 * the differences between two files), and has applications in bio informatics.
 */
public class LongestCommonSubSequence {
    /**
     * Check the validation and call the util function
     * {@link LongestCommonSubSequence#lcsUtilRecursively(String, String, int, int)}
     * @param s1
     * @param s2
     * @return
     */
    public int findLongestCommonSubSequenceRecursively(String s1, String s2){
        if(s1==null && s2 == null){
            return -1;
        }else if(s1==null && (s2!=null && s2.length()>0)){
            return s2.length();
        }else if(s2==null && (s1!=null && s1.length()>0)){
            return s1.length();
        }else{
           return lcsUtilRecursively(s1,s2,s1.length()-1,s2.length()-1);
        }
    }

    /**
     *  Calculate the lcs
     * @param s1
     * @param s2
     * @param len1
     * @param len2
     * @return
     */
    /**
     * String s1 = "AGGTAB";
     * String s2 = "GXTXAYB";
     */
    private int lcsUtilRecursively(String s1,String s2,int len1, int len2){
        if(len1 == -1 || len2 == -1){
            return 0;
        }
        if(s1.charAt(len1)==s2.charAt(len2)){
           // System.out.println("Matched : "+s1.charAt(len1)+" s1 pos : "+len1+" s2 pos : "+len2);
            return 1+lcsUtilRecursively(s1,s2,len1-1,len2-1);
        }else{
            return Math.max(lcsUtilRecursively(s1,s2,len1-1,len2),
                             lcsUtilRecursively(s1,s2,len1,len2-1));
        }

    }

    /**
     * Find the lcs in tabular way.
     * @param s1
     * @param s2
     * @return
     */
    public int lcsUtilTabular(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] lcsMatrix = new int[len1+1][len2+1];
        /*for(int i=0;i<=len1;i++){
            lcsMatrix[i][0] = 0;
        }
        for(int i=0;i<=len2;i++){
            lcsMatrix[0][i] = 0;
        }*/
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0 || j==0){
                    lcsMatrix[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    lcsMatrix[i][j] = 1+ lcsMatrix[i-1][j-1];
                }else{
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i-1][j],lcsMatrix[i][j-1]);
                }
            }
        }
        return lcsMatrix[len1][len2];
    }


}
