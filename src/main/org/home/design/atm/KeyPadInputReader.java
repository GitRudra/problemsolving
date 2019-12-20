package org.home.design.atm;

public class KeyPadInputReader implements InputReader {
    @Override
    public String read() {
        System.out.println("Read keypad input !!!");
        return "1234";
    }
}
