package com.calculator.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ModelNonParameterizedTest {

    private Model model;

    @Before
    public void init() {
        model = new Model();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldCorrectlyAddTwoSingleDigitNumbers() {
        int operator1 = 67;
        int operator2 = 1045;
        int expectedResults = 1112;
        int actualResult = model.sum(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyAddTwoLargeNumbers() {
        int operator1 = 300067;
        int operator2 = 779000;
        int expectedResults = 1079067;
        int actualResult = model.sum(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyAddTwoNegativeNumbers() {
        int operator1 = -670;
        int operator2 = 9;
        int expectedResults = -661;
        int actualResult = model.sum(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyAddToZero() {
        int operator1 = 670;
        int operator2 = 0;
        int expectedResults = 670;
        int actualResult = model.sum(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlySubtractTwoSingleDigitNumbers() {
        int operator1 = 6798;
        int operator2 = 1045;
        int expectedResults = 5753;
        int actualResult = model.subtraction(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlySubtractTwoLargeNumbers() {
        int operator1 = 6000670;
        int operator2 = 2790009;
        int expectedResults = 3210661;
        int actualResult = model.subtraction(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlySubtractTwoNegativeNumbers() {
        int operator1 = -670;
        int operator2 = 9;
        int expectedResults = -679;
        int actualResult = model.subtraction(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlySubtractToZero() {
        int operator1 = 670;
        int operator2 = 0;
        int expectedResults = 670;
        int actualResult = model.subtraction(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyMultiplyTwoSingleDigitNumbers() {
        int operator1 = 6798;
        int operator2 = 1045;
        int expectedResults = 7103910;
        int actualResult = model.multiplication(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyMultiplyTwoLargeNumbers() {
        int operator1 = 6006;
        int operator2 = 2790;
        int expectedResults = 16756740;
        int actualResult = model.multiplication(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyMultiplyTwoNegativeNumbers() {
        int operator1 = -784;
        int operator2 = 98;
        int expectedResults = -76832;
        int actualResult = model.multiplication(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyMultiplyToZero() {
        int operator1 = 670;
        int operator2 = 0;
        int expectedResults = 0;
        int actualResult = model.multiplication(operator1, operator2);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void shouldCorrectlyDivideTwoSingleDigitNumbers() {
        int operator1 = 6798;
        int operator2 = 1045;
        double expectedResults = 6.5053;
        double actualResult = model.division(operator1, operator2);
        assertEquals(expectedResults, actualResult, 0.0001);
    }

    @Test
    public void shouldCorrectlyDivideTwoLargeNumbers() {
        int operator1 = 6006;
        int operator2 = 2790;
        double expectedResults = 2.1527;
        double actualResult = model.division(operator1, operator2);
        assertEquals(expectedResults, actualResult, 0.0001);
    }

    @Test
    public void shouldCorrectlyDivideTwoNegativeNumbers() {
        int operator1 = -784;
        int operator2 = 98;
        double expectedResults = -8.0;
        double actualResult = model.division(operator1, operator2);
        assertEquals(expectedResults, actualResult, 0.0001);
    }

    @Test
    public void shouldCorrectlyDivideToZero() {
        int operator1 = 0;
        int operator2 = 670;
        double expectedResults = 0;
        double actualResult = model.division(operator1, operator2);
        assertEquals(expectedResults, actualResult, 0.0001);
    }

    @Test
    public void shouldThrowExceptionIfDivideByZeroPerformed() {
        exceptionRule.expect(ArithmeticException.class);
        exceptionRule.expectMessage("Argument 'divisor' is 0");
        model.division(5, 0);
    }
}
