package org.calculator;

import java.util.Scanner;

import static java.lang.System.*;

public class Calculator {

    public static final String CHOOSE_AN_OPERATOR = "Choose an operator: +, -, *, or / (q for quit)";
    public static final String NOT_A_NUMBER_CHOOSE_A_NUMBER = "Not a number, choose a number";
    public static final String WRONG_OPERATOR_CHOOSE = "Wrong operator, choose: +, -, * or / (q for quit)";

    private Scanner in;

    private CalculateInput calculateInput;

    public Calculator(Scanner scanner) {
        this.in = scanner;
        this.calculateInput = new CalculateInput();
    }

    public void process() {
        System.out.println(CHOOSE_AN_OPERATOR);
        while (in.hasNext()) {
            String read = in.nextLine();
            calculateInput(read);
            if ("q".equalsIgnoreCase(read)) {
                break;
            }
        }
    }

    void calculateInput(String read) {
        try {
            setInputValues(calculateInput, read);
            if (calculateInput.readyToCalculate()) {

                Integer sum = calculate(calculateInput);

                System.out.println("=" + sum);
                System.out.println(CHOOSE_AN_OPERATOR);
                // reset variables
                calculateInput = new CalculateInput();
            }
        } catch (NumberFormatException ex) {
            out.println(NOT_A_NUMBER_CHOOSE_A_NUMBER);
        }
    }

    static Integer calculate(CalculateInput input) {
        //Calculate
        return switch (input.getOperator()) {
            case "+" -> input.getFirstCalculateNumber() + input.getSecondCalculateNumber();
            case "-" -> input.getFirstCalculateNumber() - input.getSecondCalculateNumber();
            case "*" -> input.getFirstCalculateNumber() * input.getSecondCalculateNumber();
            case "/" -> input.getFirstCalculateNumber() / input.getSecondCalculateNumber();
            default -> 0;
        };
    }

    static void setInputValues(CalculateInput input, String read) {

        if (!input.hasFirstCalculateNumber() && input.hasOperator()) {
            input.setFirstCalculateNumber(Integer.valueOf(read));
            out.print(input.getFirstCalculateNumber() + input.getOperator());
        } else if (!input.hasSecondCalculateNumber() && input.hasOperator()) {
            input.setSecondCalculateNumber(Integer.valueOf(read));
            out.print(input.getFirstCalculateNumber() + input.getOperator() + input.getSecondCalculateNumber());
        }
        if (!input.hasOperator()) {
            input.setOperator(switch (read) {
                case "+" -> "+";
                case "-" -> "-";
                case "*" -> "*";
                case "/" -> "/";
                default -> null;
            });
            if (!input.hasOperator()) {
                out.println(WRONG_OPERATOR_CHOOSE);
            }
        }
    }

    public void calculate(String s) {
    }
}
