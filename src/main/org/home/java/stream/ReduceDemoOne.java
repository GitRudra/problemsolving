package org.home.java.stream;

import java.util.Arrays;
import java.util.function.Consumer;

public class ReduceDemoOne {
    public static void main(String[] args) {
        int[] array = {23,43,56,97,32};
        Arrays.stream(array).reduce((x,y)->x+y).ifPresent(s-> System.out.println(s));
        Arrays.stream(array).reduce(Integer::sum).ifPresent(s-> System.out.println(s));
        //Arrays.stream(array).reduce(Statistics)
    }
}
