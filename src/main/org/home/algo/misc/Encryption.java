package org.home.algo.misc;

import java.io.IOException;
import java.util.Scanner;

public class Encryption {

    // Complete the encryption function below.
    public static String encryption(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        String spaceRemovedString = removeSpaces(s);
        int length = s.length();
        double sqrt = Math.sqrt(length);
        int row = (int) Math.floor(sqrt);
        int column = (int) Math.ceil(sqrt);
        if(row*column<length){
            row = column;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                int pos = column*j+i;
                if(pos>=length){
                    break;
                }
                sb.append(spaceRemovedString.charAt(pos));
            }
            sb.append(" ");
        }

      return sb.toString();
    }

    private static String removeSpaces(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!Character.isSpaceChar(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = encryption(s);
        System.out.println(result);

        scanner.close();
    }
}
