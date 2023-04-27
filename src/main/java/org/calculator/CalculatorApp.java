package org.calculator;

import java.util.Scanner;


public class CalculatorApp {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Scanner(System.in));
        calculator.process();
    }
}