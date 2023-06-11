package com.example.utils;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@UtilityClass
public class Validation {



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
