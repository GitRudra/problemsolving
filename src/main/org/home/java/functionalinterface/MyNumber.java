package org.home.java.functionalinterface;

public class MyNumber {

    private long firstNumber;
    private long secondNumber;

    public MyNumber(long firstNumber, long secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public long process(Calculator calc){
        return calc.calculate(firstNumber,secondNumber);
    }

    public long getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(long firstNumber) {
        this.firstNumber = firstNumber;
    }

    public long getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(long secondNumber) {
        this.secondNumber = secondNumber;
    }
}
