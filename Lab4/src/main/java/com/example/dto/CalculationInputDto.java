package com.example.dto;

import lombok.*;



@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CalculationInputDto {

    private double[] dividend;
    private double[] divisor;
    private boolean showSteps;

}
