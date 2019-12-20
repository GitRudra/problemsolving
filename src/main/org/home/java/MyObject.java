package org.home.java;

import java.io.Serializable;

public class MyObject implements Serializable, Cloneable {

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MyObject() {
        System.out.println("Constructor Called !!!");
    }
}