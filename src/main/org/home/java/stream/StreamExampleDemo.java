package org.home.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExampleDemo {

    public static void main(String[] args) {
        /*streamMatch();
        collect();
        count();
        filter(x-> x%2==0);
        filter(x-> x%2==1);
        filter(x-> x==x);
        find();
        iterate();
        map();*/
        forEachCheck();
    }
    private static void streamMatch(){
        Predicate<Integer> predicate = x->x%2==0;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println("All match : " + list.stream().allMatch(predicate));
        System.out.println("Any match : " + list.stream().anyMatch(predicate));
        System.out.println("No match : " + list.stream().noneMatch(predicate));
    }

    private static void collect(){
        //Predicate<Integer> predicate = x->x%2==0;
        List<Integer> list = Arrays.asList(1,3,5);
        System.out.println("Sum : " + list.stream().collect(Collectors.summingInt(i->i)));
        System.out.println("Square Sum : " + list.stream().collect(Collectors.summingInt(i->i*i)));
//        System.out.println("Sum : " + list.stream().mapToInt());
//        System.out.println("Square Sum : " + list.stream().collect(Collectors.summingInt(i->i*i)));
    }

    private static void count(){
        Predicate<Integer> predicate = x->x%2==0;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println("Count % 2 : " + list.stream().filter(predicate).count());
        System.out.println("Count % 6: " + list.stream().filter(predicate).filter(x->x%3==0).count());
    }

    private static void filter(Predicate<Integer> p){
        //Predicate<Integer> predicate = x->x%2==0;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println("Stream after filter : ");
        list.stream().filter(p).forEach(System.out::print);
        System.out.println(" ");
        //System.out.println("Count % 6: " + list.stream().filter(predicate).filter(x->x%3==0).count());
    }

    private static void find(){
        List<String> list = Arrays.asList("G","B","F","E");
        String any = list.stream().findAny().get();
        System.out.println("FindAny: "+ any);
        String first = list.stream().findFirst().get();
        System.out.println("FindFirst: "+ first);
        String notFound = list.stream().findAny().get();
        System.out.println("FindFirst: "+ notFound);
    }

    //seed the initial element
    //f a function to be applied to to the previous element to produce a new element
    private static void iterate(){
        IntStream stream = IntStream.iterate(3,n->n*2).limit(5);
        System.out.println("\nIterating over the stream ");
        stream.forEach(System.out::print);
    }

    private static void map(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream().mapToInt(i->i*i).forEach(e-> System.out.print(e+" "));
       // List<Integer> mappedElement = list.stream().map(i->i*i*i).collect(Collectors.toList());
    }

    private static void forEachCheck(){
        IntStream.range(1,1000).parallel().forEachOrdered(e-> System.out.println(e+" "));
    }
}
