package org.home.hackerearth;

public class Test extends PickigCoins {

    public void f(Exception e){
        System.out.println("Exception");
    }

    public void f(NullPointerException n){
        System.out.println("NullPointerException");
    }
    public  void f(Object o){
        System.out.println("Object");
    }

    public void f(String s){
        System.out.println("String");
    }

    public static void main(String[] args) {
        Test t = new Test();
        //t.f(null);
    }
}
