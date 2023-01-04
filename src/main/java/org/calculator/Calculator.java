package org.calculator;

import java.util.Scanner;


public class Calculator {

    public static final String CHOOSE_AN_OPERATOR = "Choose an operator: +, -, *, or / (q for quit)";
    public static final String NOT_A_NUMBER_CHOOSE_A_NUMBER = "Not a number, choose a number";
    public static final String WRONG_OPERATOR_CHOOSE = "Wrong operator, choose: +, -, * or / (q for quit)+";

    public static void main(String[] args) {

        System.out.println(CHOOSE_AN_OPERATOR);
        Scanner in = new Scanner(System.in);
        CalculateInput calculateInput = new CalculateInput();

        while (in.hasNext()) {
            try {
                String read = in.nextLine();
                if ("q".equalsIgnoreCase(read)) {
                    break; // quit
                }
                setInputValues(calculateInput, read);
                if (calculateInput.readyToCalculate()) {

                    Integer sum = calculate(calculateInput);

                    System.out.println("=" + sum);
                    System.out.println(CHOOSE_AN_OPERATOR);
                    // reset variables
                    calculateInput = new CalculateInput();

                }
            } catch (NumberFormatException ex) {
                System.out.println(NOT_A_NUMBER_CHOOSE_A_NUMBER);
            }
        }
    }

    private static Integer calculate(CalculateInput input) {
        //Calculate
        return switch (input.getOperator()) {
            case "+" -> input.getFirstCalculateNumber() + input.getSecondCalculateNumber();
            case "-" ->  input.getFirstCalculateNumber() - input.getSecondCalculateNumber();
            case "*" ->  input.getFirstCalculateNumber() * input.getSecondCalculateNumber();
            case "/" -> input.getFirstCalculateNumber() / input.getSecondCalculateNumber();
            default -> 0;
        };
    }

    private static void setInputValues(CalculateInput input, String read) {

        if (!input.hasFirstCalculateNumber() && input.hasOperator()) {
            input.setFirstCalculateNumber(Integer.valueOf(read));
            System.out.print(input.getFirstCalculateNumber() + input.getOperator());
        } else if (!input.hasSecondCalculateNumber()  && input.hasOperator()) {
            input.setSecondCalculateNumber(Integer.valueOf(read));
            System.out.print(input.getFirstCalculateNumber() + input.getOperator() + input.getSecondCalculateNumber());
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
                System.out.println(WRONG_OPERATOR_CHOOSE);
            }
        }
    }
}