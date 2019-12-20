package org.home.java.functionalinterface;

import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaceTester {

    public static void main(String[] args) {
        /*Calculator calc = (x,y)->x+y;
        System.out.println(calc.calculate(10,20));
        operation((x,y)->x*y);
        operation((x,y)->x+y);
        operation((x,y)->x-y);
        operation((x,y)->x/y);
        operation((x,y)->x%y);
        operation((x,y)->x*y);
        operation((x,y)-> (long) Math.pow(x,y));*/
        test();
    }

    public static void operation(Calculator calc){
        int x = 10;
        int y = 20;
        System.out.println(calc.calculate(x,y));
    }

    static void test(){
        List<MyNumber> myNumbers = new ArrayList<>();
        myNumbers.add(new MyNumber(20,30));
        myNumbers.add(new MyNumber(40,50));
        myNumbers.add(new MyNumber(60,20));
        Calculator calc = (x,y)->x+y;
        for(MyNumber num : myNumbers){
            System.out.println(num.process(calc));
        }
        myNumbers.stream();
    }
}
