package org.home.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatStreamDemo {

    public static void main(String[] args) {
        concatStream();
        concatStreamAndRemoveDuplicate();
        concatList();
        concatListAndRemoveDuplicates();
    }

    private static void concatStream(){
        Stream<String> stream1 = Stream.of("AA","BB","CC");
        Stream<String> stream2 = Stream.of("AA","BB","CC");
        Stream<String> stream3 = Stream.concat(stream1,stream2);
        System.out.println("\nConcatenate Stream: =>");
        stream3.forEach(System.out::print);
    }

    private static void concatStreamAndRemoveDuplicate(){
        Stream<String> stream1 = Stream.of("AA","BB","CC");
        Stream<String> stream2 = Stream.of("AA","BB","CC","DD");
        Stream<String> stream3 = Stream.concat(stream1,stream2).distinct();
        System.out.println("\nStream After Removing Duplicates: =>");
        stream3.forEach(System.out::print);
    }

    private static void concatList(){
        List<Book> list1 = new ArrayList<>();
        List<Book> list2 = new ArrayList<>();

        list1.add(new Book("SCJP",600));
        list1.add(new Book("Spring In Action",2000));
        list1.add(new Book("Effective Java",250));

        list2.add(new Book("SCJP",600));
        list2.add(new Book("Spring In Action",2000));
        list2.add(new Book("Effective Java",250));

        List<Book> list3 = Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
        System.out.println("\nConcatenate List: =>");
        list3.forEach(System.out::println);
    }

    private static void concatListAndRemoveDuplicates(){
        List<Book> list1 = new ArrayList<>();
        List<Book> list2 = new ArrayList<>();

        list1.add(new Book("Scala",600));
        list1.add(new Book("Spring In Action",2000));
        list1.add(new Book("Effective Java",250));

        list2.add(new Book("SCJP",600));
        list2.add(new Book("Spring In Action",2000));
        list2.add(new Book("Java Concurrency In Practice",400));

        List<Book> list3 = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());

        System.out.println("\nList After Removing Duplicates: =>");
        list3.forEach(System.out::println);
    }


    private static void concatArray(){
        Book[] bk1 = new Book[3];
        Book[] bk2 = new Book[3];
        bk1[0] = new Book("Core Java", 200);
        bk1[1] = new Book("Spring MVC", 300);
        bk1[2] = new Book("Learning Freemarker", 150);
        bk2[0] = new Book("Core Java", 200);
        bk2[1] = new Book("Spring MVC", 300);
        bk2[2] = new Book("Learning Hibernate", 400);

        Book[] bks = (Book[]) Stream.concat(Stream.of(bk1),Stream.of(bk2)).toArray(b->new Book[b]);
    }
}
