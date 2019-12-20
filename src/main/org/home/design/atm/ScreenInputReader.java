package org.home.design.atm;

public class ScreenInputReader implements InputReader {
    @Override
    public String read() {
        System.out.println("Read screen input !!!");
        return "SCREEN_INPUT";
    }
}
