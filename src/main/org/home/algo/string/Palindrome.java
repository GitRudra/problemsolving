package org.home.algo.string;


import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        //Scanner
        Palindrome pal = new Palindrome();
        Scanner s = new Scanner(System.in);
        int inputSize = s.nextInt();
        //String[] inputs = new String[][inputSize];
        for(int i=0;i<inputSize;i++){
            System.out.println(pal.checkAndGetPalindromeLength(s.next()));
        }


    }

    public String checkAndGetPalindromeLength(String s){
        String RESULT = "";
        if(s==null || s.length()==0){
            return "NO";
        }
        if(isPalindrome(s)){
            if(s.length()%2==0){
                return "YES EVEN";
            }else{
                return "YES ODD";
            }
        }else{
            return "NO";
        }

    }

    private boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
