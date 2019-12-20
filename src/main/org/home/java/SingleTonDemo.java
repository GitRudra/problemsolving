package org.home.java;

import java.io.Serializable;

public class SingleTonDemo implements Serializable,Cloneable {
    private static class SingleTonDemoHelper{
        private static final SingleTonDemo INSTANCE = new SingleTonDemo();
    }

    public static SingleTonDemo getInstance(){
        return SingleTonDemoHelper.INSTANCE;
    }
    /*private static SingleTonDemo ourInstance = new SingleTonDemo();

    public static SingleTonDemo getInstance() {
        return ourInstance;
    }*/

    private SingleTonDemo() {
    }

    protected Object readResolve(){
        return getInstance();
    }
}
