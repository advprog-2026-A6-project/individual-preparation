package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticUtilitySubtractTest {

    final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void testPositiveNumbers() {
        double result = arithmeticUtility.subtract(10.0, 4.0);
        assertEquals(6.0, result);
    }

    @Test
    void testWithZero() {
        double result1 = arithmeticUtility.subtract(5.0, 0.0);
        double result2 = arithmeticUtility.subtract(0.0, 5.0);

        assertEquals(5.0, result1);
        assertEquals(-5.0, result2);
    }

    @Test
    void testNegativeNumbers() {
        double result1 = arithmeticUtility.subtract(-5.0, -2.0);
        assertEquals(-3.0, result1);

        double result2 = arithmeticUtility.subtract(-5.0, 2.0);
        assertEquals(-7.0, result2);

        double result3 = arithmeticUtility.subtract(5.0, -2.0);
        assertEquals(7.0, result3);
    }

    @Test
    void testFloatingPoint() {
        double result = arithmeticUtility.subtract(5.5, 2.2);
        assertEquals(3.3, result, 0.0001);
    }
}
