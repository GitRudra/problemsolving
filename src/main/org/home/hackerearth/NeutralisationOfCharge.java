package org.home.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

//Neutralisation of charges
public class NeutralisationOfCharge {

    public static String neutraliseCharge(String str) {
        boolean neutralise = true;

        while (neutralise) {
            neutralise = false;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (i = 0; i < str.length() - 1; i++) {         //aaacbbcccd
                if (str.charAt(i) == str.charAt(i + 1)) {
                    neutralise = true;
                    i = i + 1;
                } else {
                    sb.append(str.charAt(i));
                    //i=i+1;
                }
            }
            if(i<str.length()){
                sb.append(str.charAt(i));
            }

            if (neutralise) {
                str = sb.toString();
                //System.out.println(str);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer lengthOfInput = Integer.parseInt(s.nextLine());
        String s1;
        s1 = s.nextLine();
        String res = neutraliseCharge(s1);
        System.out.println(res.length());
        System.out.println(res);
        s.close();
    }
}
