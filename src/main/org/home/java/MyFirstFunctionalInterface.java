package org.home.java;

@FunctionalInterface
public interface MyFirstFunctionalInterface {
    public void firstWork();
//    public void firstWorkExtended();

    default public void secondWork(){
        System.out.println("Inside default method second work !!!");
    }
}
