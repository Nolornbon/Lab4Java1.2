package com.example.repo.entity;


import com.example.dto.CalculationInputDto;
import com.example.dto.Result;
import lombok.*;


@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CalcResultEntity {
    private Integer id;

    private CalculationInputDto calculationInputDto;

    private Result result;

}
