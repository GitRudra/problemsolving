package org.home.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyLambdaExamples {

    public static void main(String[] args) {

        //Method reference to static method Class::methodName
        List<Integer> integers = Arrays.asList(11,22,33,44,55,66,77,88,99);
        Optional<Integer> max = integers.stream().reduce(Math::max);
        //Method reference to instance method from instance – ClassInstance::instanceMethodName
        max.ifPresent(System.out::println);

        List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");
        //Method reference to instance method from class type – Class::instanceMethodName
        List<String> sortedStrings = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(sortedStrings);

        List<Integer> contiguousIntegers = IntStream
                                            .range(1,10)
                                            .boxed()
                                            .collect(Collectors.toCollection(ArrayList::new));
        contiguousIntegers.stream().forEach(System.out::print);
    }
}
