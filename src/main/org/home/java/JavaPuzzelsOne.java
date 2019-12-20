package org.home.java;

import java.util.*;

public class JavaPuzzelsOne {

    public static void main(String[] args) {
        problemOne();
        problemTwo(6);
        problemTwo(10);
        problemTwo(14);
        problemTwo(18);
    }


    public static void problemOne(){
        List<Integer> elements = new ArrayList<>();
        /*elements.add(10);
        elements.add(3,20);
        System.out.println(elements.get(3));*/

        for(int i = 0;i<5;i++){
            elements.add(i,i);
        }

        /*LinkedList<Integer> lList = new LinkedList<>();
        lList.add(2,10);*/

        System.out.println(elements.get(1));

        Integer[] arr = new Integer[10];
        System.out.println(arr[1]);

    }

    public static void problemTwo(int cardVal){
        switch (cardVal) {
            case 4: case 5: case 6:
            case 7: case 8:
                System.out.println("Hit");
                break;
            case 9: case 10: case 11:
                System.out.println("Double");
                break;
            case 15: case 16:
                System.out.println("Surrender");
                break;
            default:
                System.out.println("Stand");
        }

    }
}
