package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArithmeticUtilityDivideTest {

    private ArithmeticUtility arithmeticUtility;

    @BeforeEach
    void setUp() {
        arithmeticUtility = new ArithmeticUtility();
    }

    @Test
    void divideTwoPositiveNumbers() {
        assertEquals(2.0, arithmeticUtility.divide(10.0, 5.0), 0.0001);
    }

    @Test
    void dividePositiveByNegativeNumber() {
        assertEquals(-2.0, arithmeticUtility.divide(10.0, -5.0), 0.0001);
    }

    @Test
    void divideTwoNegativeNumbers() {
        assertEquals(2.0, arithmeticUtility.divide(-10.0, -5.0), 0.0001);
    }

    @Test
    void divideWithDecimals() {
        assertEquals(2.5, arithmeticUtility.divide(5.0, 2.0), 0.0001);
    }

    @Test
    void divideZeroByNumber() {
        assertEquals(0.0, arithmeticUtility.divide(0.0, 5.0), 0.0001);
    }

    @Test
    void divideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> arithmeticUtility.divide(5.0, 0.0));
    }
}