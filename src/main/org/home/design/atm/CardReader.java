package org.home.design.atm;

public class CardReader implements InputReader {
    @Override
    public String read() {
        System.out.println("Read card number !!!");
        return "4111111111111111";
    }
}
