package org.home.java.functionalinterface;

@FunctionalInterface
public interface Calculator {

    /**
     *
     * @param num1 first argument
     * @param num2 second argument
     * @return value of num1 operator num2
     */
    long calculate(long num1, long num2);
}
