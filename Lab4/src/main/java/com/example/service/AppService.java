package com.example.service;

import com.example.dto.CalculationInputDto;
import com.example.dto.CalculationOutputDto;


public interface AppService {

    Integer calculate(CalculationInputDto calculationInputDto);

    CalculationOutputDto getResults(Integer id);
}
