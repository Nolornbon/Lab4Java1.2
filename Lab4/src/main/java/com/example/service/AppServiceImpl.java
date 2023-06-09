package com.example.service;

import com.example.dto.CalculationInputDto;
import com.example.dto.CalculationOutputDto;
import com.example.dto.Result;
import com.example.repo.Repo;
import com.example.repo.entity.CalcResultEntity;
import com.example.utils.PolynomialDivision;
import com.example.utils.Validation;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;



@Service
public class AppServiceImpl implements AppService {

    private final Repo repo;

    public AppServiceImpl(Repo repo) {
        this.repo = repo;
    }


    @Override
    public Integer calculate(CalculationInputDto calculationInputDto) {
       Validation.validateInput(calculationInputDto.getDividend(),calculationInputDto.getDivisor());
        Result divisionResult = PolynomialDivision.dividePolynomials(calculationInputDto.getDividend(),calculationInputDto.getDivisor(),calculationInputDto.isShowSteps());
        CalcResultEntity entity = CalcResultEntity.builder()
                .calculationInputDto(calculationInputDto)
                .result (divisionResult)
                .build();
        return repo.saveCalcResult(entity);
    }


    @Override
    public CalculationOutputDto getResults(Integer id) {

        CalcResultEntity calcResultEntity = repo.getResultById(id);
        if (calcResultEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found");
         }
        CalculationOutputDto calculationOutputDto;
        calculationOutputDto = CalculationOutputDto.builder()
                .id(calcResultEntity.getId())
                .calculationInputDto(calcResultEntity.getCalculationInputDto())
                .result(calcResultEntity.getResult())
                .build();

        return calculationOutputDto;
    }
}
