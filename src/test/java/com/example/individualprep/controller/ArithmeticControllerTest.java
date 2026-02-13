package com.example.individualprep.controller;

import com.example.individualprep.dto.ArithmeticRequest;
import com.example.individualprep.dto.ArithmeticResponse;
import com.example.individualprep.service.ArithmeticUtility;
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
class ArithmeticControllerTest {

    @InjectMocks
    private ArithmeticController arithmeticController;

    @Mock
    private ArithmeticUtility arithmeticUtility;

    private ArithmeticRequest request;

    @BeforeEach
    void setUp() {
        request = new ArithmeticRequest(5.0, 3.0, 2);
    }

    @Test
    void testAdd() {
        when(arithmeticUtility.add(5.0, 3.0)).thenReturn(8.0);

        ResponseEntity<ArithmeticResponse> response = arithmeticController.add(request);

        verify(arithmeticUtility).add(5.0, 3.0);
        assertEquals(8.0, response.getBody().result());
    }

    @Test
    void testSubtract() {
        when(arithmeticUtility.subtract(5.0, 3.0)).thenReturn(2.0);

        ResponseEntity<ArithmeticResponse> response = arithmeticController.subtract(request);

        verify(arithmeticUtility).subtract(5.0, 3.0);
        assertEquals(2.0, response.getBody().result());
    }

    @Test
    void testMultiply() {
        when(arithmeticUtility.multiply(5.0, 3.0)).thenReturn(15.0);

        ResponseEntity<ArithmeticResponse> response = arithmeticController.multiply(request);

        verify(arithmeticUtility).multiply(5.0, 3.0);
        assertEquals(15.0, response.getBody().result());
    }

    @Test
    void testDivide() {
        when(arithmeticUtility.divide(6.0, 3.0)).thenReturn(2.0);

        ArithmeticRequest divideRequest = new ArithmeticRequest(6.0, 3.0, null);

        ResponseEntity<ArithmeticResponse> response = arithmeticController.divide(divideRequest);

        verify(arithmeticUtility).divide(6.0, 3.0);
        assertEquals(2.0, response.getBody().result());
    }

    @Test
    void testExponent() {
        when(arithmeticUtility.exponent(5.0, 2)).thenReturn(25.0);

        ResponseEntity<ArithmeticResponse> response = arithmeticController.exponent(request);

        verify(arithmeticUtility).exponent(5.0, 2);
        assertEquals(25.0, response.getBody().result());
    }

    @Test
    void testExponentBadRequestWhenNull() {
        ArithmeticRequest badRequest = new ArithmeticRequest(5.0, 3.0, null);

        ResponseEntity<ArithmeticResponse> response = arithmeticController.exponent(badRequest);

        assertNull(response.getBody());
        verify(arithmeticUtility, never()).exponent(anyDouble(), anyInt());
    }
}
