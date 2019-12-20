package org.home.design.snakeladder;

import java.util.Random;

public class Die {
    static Random randomGenerator = new Random();
    public static int getRolled(){
        return randomGenerator.nextInt(6);
    }
}
