package org.home.java.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomIntDemo {

    private static final List<Integer> validPasswords = new ArrayList<>();
    static{
        IntStream.rangeClosed('0','9').forEach(validPasswords::add);
        IntStream.rangeClosed('a','z').forEach(validPasswords::add);
    }

    public static void main(String[] args) {
        int passwordLength = 8;
        System.out.println("---------- Password --------------");
        Random random = new Random();
        for(int i = 0;i<5;i++){
            random.ints(passwordLength,0,validPasswords.size()).map(validPasswords::get)
                    .forEach(s-> System.out.print((char)s));
            System.out.println("");
        }
    }
}
