package org.home.algo.string;

public class StringReverseUtil {

    public static void reverse(char[] input, int start, int end){
        char ch;
        while(start<end){
            ch = input[start];
            input[start] = input[end];
            input[end] = ch;
            start++;
            end--;
        }
    }

    public static String reverseSentenceWordWise(char[] s,int start,int end){
        reverse(s,start,end);

        int l=0,m;
        for(int i=0;i<s.length;i++){
            if(s[i]==' '){
               m=i-1;
               reverse(s,l,m);
               while(s[i]==' '){
                   i++;
               }
               l=i;
            }
        }
        if(s[l] !=' '){
            reverse(s,l,end);
        }

        return String.valueOf(s);
    }

    public static String reverseSentenceWordWise(String sentence){
        if(sentence==null|| sentence.length()==0){
            return " ";
        }else{
            return  reverseSentenceWordWise(sentence.toCharArray(),0,sentence.length()-1);
        }
    }
}
