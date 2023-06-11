package com.example.utils;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class Format {

    public static String formatPolynomial(double[] polynomial) {
        StringBuilder formattedPolynomial = new StringBuilder();

        int degree = polynomial.length - 1;
        for (int i = 0; i <= degree; i++) {
            double coefficient = polynomial[i];
            if (coefficient != 0) {
                if (formattedPolynomial.length() > 0) {
                    if (coefficient >= 0) {
                        formattedPolynomial.append(" + ");
                    } else {
                        formattedPolynomial.append(" - ");
                        coefficient = Math.abs(coefficient);
                    }
                } else if (coefficient < 0) {
                    formattedPolynomial.append("-");
                    coefficient = Math.abs(coefficient);
                }

                if (coefficient != 1 || i == degree) {
                    formattedPolynomial.append(coefficient);
                }

                if (degree - i > 0) {
                    formattedPolynomial.append("x");
                    if (degree - i > 1) {
                        formattedPolynomial.append("^").append(degree - i);
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
