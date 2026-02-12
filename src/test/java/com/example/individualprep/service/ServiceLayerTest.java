package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ServiceLayerTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void addReturnsElementWiseSumWhenVectorsHaveSameLength() {
        double[] result = vectorUtility.add(new double[]{1.0, 2.5, -3.0}, new double[]{4.0, -0.5, 3.0});

        assertArrayEquals(new double[]{5.0, 2.0, 0.0}, result);
    }

    @Test
    void addReturnsDefaultVectorWhenAnyInputIsNull() {
        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, vectorUtility.add(null, new double[]{1.0, 2.0, 3.0}));
        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, vectorUtility.add(new double[]{1.0, 2.0, 3.0}, null));
    }

    @Test
    void addReturnsDefaultVectorWhenVectorLengthsDiffer() {
        double[] result = vectorUtility.add(new double[]{1.0, 2.0}, new double[]{3.0, 4.0, 5.0});

        assertArrayEquals(new double[]{0.0, 0.0, 0.0}, result);
    }
}
