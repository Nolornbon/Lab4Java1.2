package com.example.utils;

import com.example.dto.Result;
import com.example.dto.Step;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class PolynomialDivision {

            public static Result dividePolynomials(double[] dividend, double[] divisor, boolean showSteps) {
                int dividendLength = dividend.length;
                int divisorLength = divisor.length;
                int quotientLength = dividendLength - divisorLength + 1;
                double[] quotient = new double[quotientLength];
                double[] remainder = dividend.clone();

                List<Step> steps = new ArrayList<>();

                for (int i = 0; i < quotientLength; i++) {
                    double divisorFactor = remainder[i] / divisor[0];
                    quotient[i] = divisorFactor;

                    for (int j = 0; j < divisorLength; j++) {
                        remainder[i + j] -= divisor[j] * divisorFactor;
                    }

                    if (showSteps) {

                        double[] formattedQuotient = Format.removeLeadingZeros(Arrays.copyOfRange(quotient, 0, divisorLength));
                        double[] formattedRemainder = Format.removeLeadingZeros(Arrays.copyOfRange(remainder, 0,dividendLength));
                        String formattedQuotientStr = Format.formatPolynomial(formattedQuotient);
                        String formattedRemainderStr = Format.formatPolynomial(formattedRemainder);

                        Step step = new Step(i, formattedQuotientStr, formattedRemainderStr);
                        steps.add(step);
                    }
                }

                Result resultObj = new Result(steps);

                double[] formattedQuotient = Format.removeLeadingZeros(quotient);
                double[] formattedRemainder = Format.removeLeadingZeros(remainder);

                resultObj.setFinalQuotient(Format.formatPolynomial(formattedQuotient));
                resultObj.setFinalRemainder(Format.formatPolynomial(formattedRemainder));

                return resultObj;
            }
}

