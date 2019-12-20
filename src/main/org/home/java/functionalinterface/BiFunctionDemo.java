package org.home.java.functionalinterface;

import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {
        BiFunction<String, String, String> biFunc = (s1,s2)->{
            String s3 = s1+s2;
            return s3;
        };
        System.out.println(biFunc.apply("Hello"," World"));
    }
}
