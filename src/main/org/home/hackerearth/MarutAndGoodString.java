package org.home.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Marut loves good strings. According to him, good strings are those which contain
 * either all alphabets of uppercase or lowercase.
 * While he is preparing for his exams, he finds many bad strings in his book
 * and wants to convert them to good strings.
 * But he wants to do this in minimum number of operations.
 * In one operation, he can pick only one character
 * of any case and convert it to any other case.
 *
 * As his exams are going on, he wants your help.
 *
 * Input:
 * The first line contains an integer T, denoting the number of test cases.
 * Each test case consists of only one line with a string
 * S which contains uppercase and lowercase alphabets..
 *
 * Output:
 * Print the minimum number of operations, in which Marut can obtain a good string.
 * Print the answer for each test case in new line.
 *
 * Constraints:
 * 1 ≤ T ≤ 10
 * If T is not in this range, print "Invalid Test" (without the quotes)
 * 1 ≤ Length of S ≤ 100
 * S can contain numbers, special characters but no spaces.
 * If the length of string is not in the above range or
 * it does not contain any alphabets, print "Invalid Input" (without the quotes)
 *
 * For Example, if the input is:
 * 0
 * TestString
 * SAMPLE INPUT
 * 3
 * abcEfg
 * !@6#2
 * 123A
 *
 * SAMPLE OUTPUT
 * 1
 * Invalid Input
 * 0
 *
 * Print "Invalid Test" (without the quotes)
 */
public class MarutAndGoodString {

    public static void main(String[] args) throws Exception {
        // System.out.println(String.va);
        Scanner sc  =  new Scanner(System.in);
        //String testCaseNumberStr = sc.nextLine();
        int testCases = 0;
        try{
            testCases = Integer.parseInt(sc.nextLine());
            if(testCases<=0 || testCases>10){
                System.out.println("Invalid Test");
            }else{
                List<String> resultList = new ArrayList<>();
                for(int i=0;i<testCases;i++){
                    resultList.add(marutGoodStringConverter(sc.nextLine()));
                }

                resultList.stream().forEach(e-> System.out.println(e));
            }
        }catch(NumberFormatException e){
            System.out.println("Invalid Test");
            //throw new Exception(e);
        }



        sc.close();
    }

    public static String marutGoodStringConverter(String input){
        if(input == null || input.length() == 0 || input.length()>100){
            return "Invalid Input";
        }else{
            int capCount=0;
            int smallCount=0;
            int digitCount = 0;
            for(int i=0;i<input.length();i++){
                if(Character.isUpperCase(input.charAt(i))){
                    capCount++;
                }else if(Character.isLowerCase(input.charAt(i))){
                    smallCount++;
                }else if(Character.isDigit(input.charAt(i))){
                    digitCount++;
                }
            }

            if(capCount ==0 && smallCount == 0){
                return "Invalid Input";
            }else if((smallCount ==0 && capCount>0) ||
                    (smallCount>0 && capCount==0)){
                return String.valueOf(0);
            }else{
                return String.valueOf(Math.min(capCount,smallCount));
            }
        }

    }
}
