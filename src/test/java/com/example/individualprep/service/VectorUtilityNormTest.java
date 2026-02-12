package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityNormTest {

    private VectorUtility vectorUtility;

    @BeforeEach
    void setUp() {
        vectorUtility = new VectorUtility();
    }

    @Test
    void testNormValues() {
        double[] vector2D = {3.0, -4.0, 12.0};
        double result2D = vectorUtility.norm(vector2D);
        assertEquals(13.0, result2D, 0.0001);

        double[] vector4D = {1.5, -2.0, 0.5, 4.0};
        double result4D = vectorUtility.norm(vector4D);
        assertEquals(4.743416490252569, result4D, 0.0001);
    }

    @Test
    void testNormWrongValues() {
        double[] vector2D = {0, 0, 0};
        double result2D = vectorUtility.norm(vector2D);
        assertNotEquals(1.0, result2D, 0.0001);

        double[] vector4D = {4.0, 0, 0, 4.0};
        double result4D = vectorUtility.norm(vector4D);
        assertNotEquals(20.0, result4D, 0.0001);
    }

    @Test
    void testNormNullArg() {
        double[] vector2D = null;
        double result2D = vectorUtility.norm(vector2D);
        assertEquals(0.0, result2D, 0.00001);

    }

}