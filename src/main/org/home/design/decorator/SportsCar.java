package org.home.design.decorator;

public class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    public void assemble(){
        super.assemble();
        System.out.println(" Adding the feature of Sports Car");
    }
}
