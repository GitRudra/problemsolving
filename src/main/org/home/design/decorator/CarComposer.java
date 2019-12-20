package org.home.design.decorator;

public class CarComposer {

    public static void main(String[] args) {

        Car sportCar = new SportsCar(new BasicCar());
        sportCar.assemble();

        Car luxurySportsCar = new SportsCar(new LuxuryCar(new BasicCar()));
        luxurySportsCar.assemble();
    }
}
