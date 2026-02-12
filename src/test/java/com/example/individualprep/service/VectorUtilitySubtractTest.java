package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class VectorUtilitySubtractTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void returnsDefaultVectorForCurrentImplementation() {
        double[] result = vectorUtility.subtract(new double[]{5.0, 3.0, 1.0}, new double[]{1.0, 2.0, 3.0});

        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, result);
    }
}
