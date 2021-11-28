package com.calculator.model;

public class Model {

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new NumberFormatException("Argument 'divisor' is 0");
        }
        return a / b;
    }
}
