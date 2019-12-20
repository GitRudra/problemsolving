package org.home.java;

public class StringDemo {

    public static void main(String[] args) {
        String str2 = "pqr";
        //String str1 = new String("pqr");
        char[] chars = {'p','q','r'};
        String str3 =new String(chars);

        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());


        String s1 = "abc";
        String s2 = s1;
        String s5 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println("== comparison : " + (s1 == s5));
        System.out.println("== comparison : " + (s1 == s2));
        System.out.println("Using equals method : " + s1.equals(s2));
        System.out.println("== comparison : " + s3 == s4);
        System.out.println("Using equals method : " + s3.equals(s4));
    }
}
