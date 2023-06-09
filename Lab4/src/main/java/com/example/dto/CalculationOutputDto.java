package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



@ToString
@RequiredArgsConstructor
@Builder
public class CalculationOutputDto {
    @JsonProperty
    private final Integer id;
    @JsonProperty
    private final CalculationInputDto calculationInputDto;
    @JsonProperty
    private final Result result;
}
