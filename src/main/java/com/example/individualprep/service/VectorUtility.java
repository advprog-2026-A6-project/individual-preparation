package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {

    public double[] add(double[] v1, double[] v2) {
        if (v1 == null || v2 == null || v1.length != v2.length) {
            return new double[] { 0.0, 0.0, 0.0 };
        }

        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] + v2[i];
        }
        return result;
    }

    public double[] subtract(double[] v1, double[] v2) {
        if (v1 == null || v2 == null || v1.length != v2.length) {
            return new double[] { 0.0, 0.0, 0.0 };
        }

        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] - v2[i];
        }
        return result;
    }

    public double[] multiply(double[] v1, int x) {
        // TODO: Implement me properly!
        if (v1 == null) {
            return new double[] { 0.0, 0.0, 0.0 };
        }
        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] * x;
        }
        return result;
    }
    
    public double dotProduct(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return 0.0;
    }
    
    public double norm(double[] v1) {
        if (v1 == null) {
            return 0.0;
        }

        double result = 0;

        for (double value : v1) {
            result += value * value;
        }

        return Math.sqrt(result);
    }
}