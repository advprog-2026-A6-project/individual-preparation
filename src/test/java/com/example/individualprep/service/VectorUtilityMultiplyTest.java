package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityMultiplyTest {

    final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void testMultiplySuccess() {
        double[] vector = {1.0, 2.0, 3.0};
        int scalar = 2;
        double[] result = vectorUtility.multiply(vector, scalar);
        double[] expected = {2.0, 4.0, 6.0};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMultiplyByZero() {
        double[] vector = {5.0, 1.0, 0.0};
        double[] result = vectorUtility.multiply(vector, 0);
        double[] expected = {0.0, 0.0, 0.0};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMultiplyNegativeScalar() {
        double[] vector = {2.0, -4.0};
        double[] result = vectorUtility.multiply(vector, -1);
        double[] expected = {-2.0, 4.0};
        assertArrayEquals(expected, result);
    }

    @Test
    void testMultiplyNullVector() {
        double[] result = vectorUtility.multiply(null, 5);
        double[] expected = {0.0, 0.0, 0.0};
        assertArrayEquals(expected, result);
    }
}
