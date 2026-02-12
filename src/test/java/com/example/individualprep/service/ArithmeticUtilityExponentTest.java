package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticUtilityExponentTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void returnsPowerForPositiveExponent() {
        double result = arithmeticUtility.exponent(2.0, 3);

        assertEquals(8.0, result);
    }

    @Test
    void returnsOneForZeroExponent() {
        double result = arithmeticUtility.exponent(10.0, 0);

        assertEquals(1.0, result);
    }

    @Test
    void returnsFractionForNegativeExponent() {
        double result = arithmeticUtility.exponent(2.0, -2);

        assertEquals(0.25, result);
    }
}
