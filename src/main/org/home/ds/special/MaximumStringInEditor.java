package org.home.ds.special;

import java.util.Arrays;

/**
 * You have given one notepad and 4 operations
 * 1. Type a character (say X).
 * 2. Select All
 * 3. Copy
 * 4. Paste
 *
 * You have given a number n and now you have to generate maximum length string by n operation.
 */
public class MaximumStringInEditor {

    /**
     * To solve the problem our intention is we will repeat the step 2,3,4
     * as much as possible as this 3 operations double the length of the string.
     * We have to find out the n for which 2,3,4 will not generate the max length.
     * The problem has sub problems:
     * 1. So Len(n) = Len(n-3)*2 //n-3 as we need three operations. where n>5
     * 3. Base cases : for n=1 to 5 we can generate maximum length only by operation 1.
     *
     * Ex: If n=6 the len(6) = len(3)*2 which is 6
     * @param n
     */
    public static void generateString(int n){
        int len = 0;
        int[] result = new int[n+1];
        Arrays.fill(result,0);
        int i;
        if(n>5){
            for(i=0;i<=5;i++){
                result[i] = i;
            }
            while(i<=n){
                result[i] = result[i-3]*2;
                i++;
            }
        }else{
            for(i=0;i<=n;i++){
                result[i] = i;
            }
        }

        System.out.println();
        System.out.print(" Max Length : " + result[n] + "  for N : " + n+" : ");
        for(int j=0;j<result[n];j++){
            System.out.print("X");
        }
    }

    public static void main(String[] args) {
       /* generateString(3);
        generateString(5);
        generateString(7);
        generateString(8);
        generateString(9);
        generateString(10);
        generateString(11);
        generateString(12);*/

        for(int i=1;i<=15;i++){
            generateString(i);
        }
    }
}
