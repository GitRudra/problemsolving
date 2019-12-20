package org.home.design.decorator;

public class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car c) {
        super(c);
    }

    public void assemble(){
        super.assemble();
        System.out.println(" Adding the feature of Luxury Car");
    }

}
