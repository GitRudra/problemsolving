package org.home.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static int findNumberOfDeletion(String str1, String str2){
        if(str1 == null || str2 == null){
            return -1;
        }
        int alphabetsize = 26;

        int[] countFrequency1 = new int[alphabetsize];
        int[] countFrequency2 = new int[alphabetsize];
        Arrays.fill(countFrequency1,0);
        Arrays.fill(countFrequency2,0);

        for(int i=0;i<str1.length();i++){
            countFrequency1[str1.charAt(i)-'a']++;
        }

        for(int i=0;i<str2.length();i++){
            countFrequency2[str2.charAt(i)-'a']++;
        }

        int deleteCount = 0;
        for(int i= 0;i<alphabetsize;i++){
            deleteCount += Math.abs(countFrequency1[i]-countFrequency2[i]);
        }
        return deleteCount;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer noOfTestCase = Integer.parseInt(s.nextLine());
        //System.out.println("Hi, " + name + ".");
        ArrayList<Integer> result = new ArrayList<>();
        String s1;
        String s2;
        for(int i=0;i<noOfTestCase;i++){
            s1 = s.nextLine();
            s2 = s.nextLine();
            int res = findNumberOfDeletion(s1,s2);
            System.out.println(res);
            result.add(res);
        }
        result.forEach(e-> System.out.println(e));
        s.close();
    }
}
