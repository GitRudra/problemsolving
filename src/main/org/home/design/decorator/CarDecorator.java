package org.home.design.decorator;

public class CarDecorator implements Car{
    protected Car C;

    public CarDecorator(Car c) {
        C = c;
    }


    @Override
    public void assemble() {
        this.C.assemble();
    }
}
