package com.example.individualprep.controller;

import com.example.individualprep.dto.VectorRequest;
import com.example.individualprep.dto.VectorResponse;
import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VectorControllerTest {

    @InjectMocks
    private VectorController vectorController;

    @Mock
    private VectorUtility vectorUtility;

    private double[] vector1;
    private double[] vector2;
    private VectorRequest request;

    @BeforeEach
    void setUp() {
        vector1 = new double[]{1.0, 2.0};
        vector2 = new double[]{3.0, 4.0};
        request = new VectorRequest(vector1, vector2, 2);
    }

    @Test
    void testAdd() {
        double[] expected = new double[]{4.0, 6.0};
        when(vectorUtility.add(vector1, vector2)).thenReturn(expected);

        ResponseEntity<VectorResponse> response = vectorController.add(request);

        verify(vectorUtility).add(vector1, vector2);
        assertArrayEquals(expected, response.getBody().result());
    }

    @Test
    void testSubtract() {
        double[] expected = new double[]{-2.0, -2.0};
        when(vectorUtility.subtract(vector1, vector2)).thenReturn(expected);

        ResponseEntity<VectorResponse> response = vectorController.subtract(request);

        verify(vectorUtility).subtract(vector1, vector2);
        assertArrayEquals(expected, response.getBody().result());
    }

    @Test
    void testMultiply() {
        double[] expected = new double[]{2.0, 4.0};
        when(vectorUtility.multiply(vector1, 2)).thenReturn(expected);

        ResponseEntity<VectorResponse> response = vectorController.multiply(request);

        verify(vectorUtility).multiply(vector1, 2);
        assertArrayEquals(expected, response.getBody().result());
    }

    @Test
    void testMultiplyBadRequestWhenScalarNull() {
        VectorRequest badRequest = new VectorRequest(vector1, vector2, null);

        ResponseEntity<VectorResponse> response = vectorController.multiply(badRequest);

        assertNull(response.getBody());
        verify(vectorUtility, never())
                .multiply(any(double[].class), any(int.class));
    }

    @Test
    void testDotProduct() {
        when(vectorUtility.dotProduct(any(double[].class), any(double[].class)))
                .thenReturn(11.0);

        ResponseEntity<VectorResponse> response = vectorController.dotProduct(request);

        verify(vectorUtility).dotProduct(any(double[].class), any(double[].class));
        assertNotNull(response.getBody());
        assertEquals(11.0, response.getBody().scalarResult());
    }


    @Test
    void testNorm() {
        when(vectorUtility.norm(any(double[].class)))
                .thenReturn(2.236);

        ResponseEntity<VectorResponse> response = vectorController.norm(request);

        verify(vectorUtility).norm(any(double[].class));
        assertNotNull(response.getBody());
        assertEquals(2.236, response.getBody().scalarResult());
    }

}
