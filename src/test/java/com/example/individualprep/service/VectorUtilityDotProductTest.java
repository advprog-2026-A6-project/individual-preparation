package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityDotProductTest {

    private VectorUtility vectorUtility;

    @BeforeEach
    void setUp() {
        vectorUtility = new VectorUtility();
    }

    @Test
    void dotProductTwoPositiveVectors() {
        double[] vectorA = {1.0, 2.0, 3.0};
        double[] vectorB = {4.0, 5.0, 6.0};

        double result = vectorUtility.dotProduct(vectorA, vectorB);

        assertEquals(32.0, result);
    }

    @Test
    void dotProductWithNegativeValues() {
        double[] vectorA = {-1.0, 2.0, -3.0};
        double[] vectorB = {4.0, -5.0, 6.0};

        double result = vectorUtility.dotProduct(vectorA, vectorB);

        assertEquals(-32.0, result);
    }

    @Test
    void dotProductWithDecimals() {
        double[] vectorA = {1.5, 2.5};
        double[] vectorB = {2.0, 3.0};

        double result = vectorUtility.dotProduct(vectorA, vectorB);

        assertEquals(10.5, result, 0.0001);
    }

    @Test
    void handleNullFirstInput() {
        double[] vectorB = {1.0, 2.0, 3.0};

        assertThrows(IllegalArgumentException.class, () ->
                vectorUtility.dotProduct(null, vectorB));
    }

    @Test
    void handleNullSecondInput() {
        double[] vectorA = {1.0, 2.0, 3.0};

        assertThrows(IllegalArgumentException.class, () ->
                vectorUtility.dotProduct(vectorA, null));
    }

    @Test
    void handleDifferentLengthVectors() {
        double[] vectorA = {1.0, 2.0, 3.0};
        double[] vectorB = {1.0, 2.0};

        assertThrows(IllegalArgumentException.class, () ->
                vectorUtility.dotProduct(vectorA, vectorB));
    }
}
