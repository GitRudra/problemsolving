package org.home.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MapToIntDemo {
    public static void main(String[] args) {
        MapToIntDemo demo = new MapToIntDemo();
        demo.executeOne();
    }

    public void executeOne(){
        Employee e1 = new Employee(1, 20);
        Employee e2 = new Employee(2, 15);
        Employee e3 = new Employee(3, 30);
        List<Employee> list = Arrays.asList(e1, e2, e3);
        Collections.sort(list,Comparator.comparing(Employee::getAge).reversed());
        list.stream().forEach(System.out::println);
//        int sum = list.stream().mapToInt(e -> e.getAge()).sum();
        List<Integer> sumList = list.stream().map(Employee::getAge).collect(Collectors.toList());
        int sum = list.stream().map(Employee::getAge).collect(Collectors.toList()).stream().reduce(0,Integer::sum);
        Comparator<Employee> ageComparator = (x,y)->Integer.compare(x.getAge(),y.getAge());

        list.stream().sorted(ageComparator).forEach(System.out::println);
        list.stream().sorted(ageComparator.reversed()).forEach(System.out::println);

        System.out.println("Sum: "+ sum);
    }
}
class Employee {
    private int id;
    private int age;
    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
