package org.home.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleTonDemoTest {

    @Test
    public void getInstance() {
        System.out.println(SingleTonDemo.getInstance().hashCode());
        System.out.println(SingleTonDemo.getInstance().hashCode());
    }
}