package org.home.algo.string;

import java.util.Arrays;

public class KMPPatternMtcher{

    public int match(String str, String pat){

        if(isEmpty(str) || isEmpty(pat)){
            return -1;
        }
        int[] lps = createLPSArray(pat);
        return matcher(str,pat,lps);
    }

    private boolean isEmpty(String str){
        return (str == null || str.length() == 0);
    }

    public int[] createLPSArray(String pat){
        int len  = 0;
        int[] lps  = new int[pat.length()];
        Arrays.fill(lps,0);

        for(int i = 0;i<lps.length;i++){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len-1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    private int matcher(String str, String pat, int[] lps){
        int i = 0;
        int j = 0;
        int lenStr = str.length();
        int lenPat = pat.length();
        while(i<lenStr){
            if(str.charAt(i)  == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == lenPat){
                System.out.println("Pattern found at "+(i-j));
                //j = lps[j-1];
                return (i-j);
            }else if(i<lenStr && pat.charAt(j) != str.charAt(i)){
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i=i+1;
                }
            }

        }
        return -1;
    }
}
