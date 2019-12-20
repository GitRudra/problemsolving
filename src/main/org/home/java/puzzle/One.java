package org.home.java.puzzle;

public class One {

    public static void main(String[] args) {
        System.out.println(isOdd(3));
        System.out.println(isOdd(-3));

        String s1 = "hello";
        s1.concat(" world");
    }

    public static boolean isOdd(int i){
        return i%2 == 1;
    }
}
