package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class VectorUtilitySubtractTest {

    private VectorUtility vectorUtility;

    @BeforeEach
    void setUp() {
        vectorUtility = new VectorUtility();
    }

    @Test
    void subtractTwoPositiveVectors() {
        double[] vectorA = {10.0, 20.0, 30.0};
        double[] vectorB = {4.0, 5.0, 6.0};
        double[] expected = {6.0, 15.0, 24.0};

        assertArrayEquals(expected, vectorUtility.subtract(vectorA, vectorB), 0.0001);
    }

    @Test
    void subtractVectorsWithNegativeValues() {
        double[] vectorA = {-5.0, 10.0, -2.0};
        double[] vectorB = {-2.0, 15.0, -5.0};
        double[] expected = {-3.0, -5.0, 3.0};

        assertArrayEquals(expected, vectorUtility.subtract(vectorA, vectorB), 0.0001);
    }

    @Test
    void subtractVectorsWithDecimals() {
        double[] vectorA = {1.5, 2.25, 3.75};
        double[] vectorB = {0.5, 1.25, 0.25};
        double[] expected = {1.0, 1.0, 3.5};

        assertArrayEquals(expected, vectorUtility.subtract(vectorA, vectorB), 0.0001);
    }

    @Test
    void handleNullFirstInput() {
        double[] vectorA = null;
        double[] vectorB = {1.0, 2.0, 3.0};
        double[] expected = {0.0, 0.0, 0.0};

        assertArrayEquals(expected, vectorUtility.subtract(vectorA, vectorB), 0.0001);
    }

    @Test
    void handleNullSecondInput() {
        double[] vectorA = {1.0, 2.0, 3.0};
        double[] vectorB = null;
        double[] expected = {0.0, 0.0, 0.0};

        assertArrayEquals(expected, vectorUtility.subtract(vectorA, vectorB), 0.0001);
    }

    @Test
    void handleVectorPanjangBerbeda() {
        double[] vectorA = {1.0, 2.0, 3.0};
        double[] vectorB = {1.0, 2.0};
        double[] expected = {0.0, 0.0, 0.0};

        assertArrayEquals(expected, vectorUtility.subtract(vectorA, vectorB), 0.0001);
    }
}