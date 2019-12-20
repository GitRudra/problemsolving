package org.home.java;

import java.util.ArrayList;
import java.util.List;

public class GenericsTester {

    class A{
        A(){
            System.out.println( " Creates instance of A");
        }

    }

    class B extends A{
        B(){
            super();
            System.out.println( " Creates instance of B");
        }
    }

    public static void main(String[] args) {
        List<? extends A> aList = new ArrayList();
        List<B> bList = new ArrayList<>();
        aList = bList;
    }
}
