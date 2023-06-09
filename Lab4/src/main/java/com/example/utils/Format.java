package com.example.utils;

import java.util.Arrays;

public class Format {
    public static String formatPolynomial(double[] polynomial) {
    StringBuilder formattedPolynomial = new StringBuilder();

    for (int i = polynomial.length - 1; i >= 0; i--) {
        double coefficient = polynomial[i];
        if (coefficient != 0) {
            if (formattedPolynomial.length() > 0) {
                formattedPolynomial.append(coefficient >= 0 ? " + " : " - ");
            }

            coefficient = Math.abs(coefficient);
            if (coefficient != 1 || i == 0) {
                formattedPolynomial.append(coefficient);
            }

            if (i > 0) {
                formattedPolynomial.append("x");
                if (i > 1) {
                    formattedPolynomial.append("^").append(i);
                }
            }
        }
    }

    return formattedPolynomial.toString();
}

    public static double[] removeLeadingZeros(double[] arr) {
        int firstNonZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > 1e-9) {
                firstNonZeroIndex = i;
                break;
            }
        }
        return Arrays.copyOfRange(arr, firstNonZeroIndex, arr.length);
    }
}
