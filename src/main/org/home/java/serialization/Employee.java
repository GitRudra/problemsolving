package org.home.java.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int age;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
