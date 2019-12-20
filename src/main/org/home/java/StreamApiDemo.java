package org.home.java;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Source : https://www.journaldev.com/2774/java-8-stream
 */
public class StreamApiDemo {

    public static int sumOfIntegers(List<Integer> list){
        return  list.stream().filter(i->i>10).mapToInt(i->i).sum();
    }

    public static void streamCollectorOne(List<Integer> list){
        list.parallelStream().filter(i->i>10).collect(Collectors.toList());
    }
}
