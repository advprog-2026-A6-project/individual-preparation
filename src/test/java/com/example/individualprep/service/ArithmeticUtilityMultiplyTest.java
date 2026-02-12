package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticUtilityMultiplyTest {

    final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void testPositiveNumbers() {
        double result = arithmeticUtility.multiply(5.0, 4.0);
        assertEquals(20.0, result);
    }

    @Test
    void testWithZero() {
        double result1 = arithmeticUtility.multiply(10.0, 0.0);
        double result2 = arithmeticUtility.multiply(0.0, 5.0);
        assertEquals(0.0, result1);
        assertEquals(0.0, result2);
    }

    @Test
    void testNegativeNumbers() {
        double result1 = arithmeticUtility.multiply(-3.0, -2.0);
        assertEquals(6.0, result1);

        double result2 = arithmeticUtility.multiply(-3.0, 4.0);
        assertEquals(-12.0, result2);

        double result3 = arithmeticUtility.multiply(2.0, -5.0);
        assertEquals(-10.0, result3);
    }

    @Test
    void testFloatingPoint() {
        double result = arithmeticUtility.multiply(2.5, 2.5);
        assertEquals(6.25, result, 0.0001);
    }
}
