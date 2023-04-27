package org.calculator;

import io.qase.api.annotation.QaseTitle;
import org.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * <p>
 *  Testa + exempel 4+8=12
 *        - exempel 4-1=3, 1-8 = -7
 *        / exempel 2/7 = 0.3 2/2 = 1
 *        * exempel 0.3*2 = 0.6
 * <p>
 */

class CalculatorTest {


    private Calculator calculator;


    @BeforeEach
    void setupCalculator() {
        Scanner sc = new Scanner(in);
        calculator = new Calculator(sc);
    }

    @Test
    @QaseTitle("addition")
    public void addition() {

        String expected = "4";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        calculator.calculateInput("+");
        calculator.calculateInput("2");
        calculator.calculateInput("2");

        String[] output = baos.toString().split("=");
        String actual = output[output.length -1].split(System.lineSeparator())[0];

        assertEquals(actual, expected);
    }

    @Test
    @QaseTitle("subraction")
    public void subraction() {

      String expected = "1";
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(baos));

      calculator.calculateInput("-");
      calculator.calculateInput("3");
      calculator.calculateInput("2");

      String[] output = baos.toString().split("=");
      String actual = output[output.length -1].split(System.lineSeparator())[0];

      assertEquals(actual, expected);

    }

    @Test
    @QaseTitle("division")
    public void division() {

        String expected = "2";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        calculator.calculateInput("/");
        calculator.calculateInput("4");
        calculator.calculateInput("2");

        String[] output = baos.toString().split("=");
        String actual = output[output.length - 1].split(System.lineSeparator())[0];

        assertEquals(actual, expected);

    }

    @Test
    @QaseTitle("multiplication")
    public void multiplication() {

        String expected = "4";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        calculator.calculateInput("*");
        calculator.calculateInput("2");
        calculator.calculateInput("2");

        String[] output = baos.toString().split("=");
        String actual = output[output.length - 1].split(System.lineSeparator())[0];

        assertEquals(actual, expected);

    }

    @Test
    @QaseTitle("divide_with_zero_should_throw_exception")
    public void wrong_input_operator() {

        String expected = "Wrong operator, choose: +, -, * or / (q for quit)";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        calculator.calculateInput("2");

        String[] output = baos.toString().split("=");
        String actual = output[output.length - 1].split(System.lineSeparator())[0];

        assertEquals(actual, expected);

    }

    @Test
    @QaseTitle("divide_with_zero_should_throw_exception")
    public void divide_with_zero_should_throw_exception() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        calculator.calculateInput("/");
        calculator.calculateInput("0");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> calculator.calculateInput("0"));
        assertEquals("/ by zero", e.getMessage());
    }
}
