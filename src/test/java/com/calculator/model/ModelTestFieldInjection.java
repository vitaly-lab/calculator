package com.calculator.model;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)

public class ModelTestFieldInjection {
    enum Type {SUM, SUBTRACTION, MULTIPLICATION, DIVISION}

    private Model model;

    @Before
    public void init() {
        model = new Model();
    }

    @Parameterized.Parameter
    public Type type;

    @Parameterized.Parameter(1)
    public int numberA;

    @Parameterized.Parameter(2)
    public int numberB;

    @Parameterized.Parameter(3)
    public double expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                {Type.SUM, 1, 1, 2},
                {Type.SUM, 2, 2, 4},
                {Type.SUM, 8, 2, 10},
                {Type.SUM, 4, 5, 9},
                {Type.SUM, 5, 5, 10},

                {Type.SUBTRACTION, 1, 1, 0},
                {Type.SUBTRACTION, 3, 2, 1},
                {Type.SUBTRACTION, 4, 2, 2},
                {Type.SUBTRACTION, 8, 5, 3},
                {Type.SUBTRACTION, 10, 5, 5},

                {Type.MULTIPLICATION, 1, 1, 1},
                {Type.MULTIPLICATION, 2, 3, 6},
                {Type.MULTIPLICATION, 3, 3, 9},
                {Type.MULTIPLICATION, 4, 2, 8},
                {Type.MULTIPLICATION, 5, 2, 10},

                {Type.DIVISION, 1, 1, 1},
                {Type.DIVISION, 2, 1, 2},
                {Type.DIVISION, 4, 2, 2},
                {Type.DIVISION, 6, 2, 3},
                {Type.DIVISION, 9, 3, 3},

        });
    }

    @Test
    public void checkSumOperation() {
        Assume.assumeTrue(type == Type.SUM);
        assertThat(model.sum(numberA, numberB), is((int) expected));
    }

    @Test
    public void checkSubtractionOperation() {
        Assume.assumeTrue(type == Type.SUBTRACTION);
        assertThat(model.subtraction(numberA, numberB), is((int) expected));
    }

    @Test
    public void checkMultiplicationOperation() {
        Assume.assumeTrue(type == Type.MULTIPLICATION);
        assertThat(model.multiplication(numberA, numberB), is((int) expected));
    }

    @Test
    public void checkDivisionOperation() {
        Assume.assumeTrue(type == Type.DIVISION);
        assertThat(model.division(numberA, numberB), is(expected));
    }
}
