package com.example.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Validation {

/*
    public static void validateInput(double[] dividend, double[] divisor) {
        if (divisor.length > dividend.length) {
            throw new IllegalArgumentException("Divisor length cannot be greater than dividend length.");


        }

        if (divisor.length == 0) {
            throw new IllegalArgumentException("Divisor cannot be empty.");

        }
        boolean allZeroes = true;
        for (double value : divisor) {
            if (value != 0.0) {
                allZeroes = false;
                break;
            }
        }
        if (allZeroes) {
            throw new IllegalArgumentException("Divisor cannot contain only zero values.");

        }
    }
}
*/


    public static void validateInput(double[] dividend, double[] divisor) {
        if (divisor.length > dividend.length) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Divisor length cannot be greater than dividend length.");
        }

        if (divisor.length == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Divisor cannot be empty.");
        }

        boolean allZeroes = true;
        for (double value : divisor) {
            if (value != 0.0) {
                allZeroes = false;
                break;
            }
        }

        if (allZeroes) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Divisor cannot contain only zero values.");
        }
    }
}
