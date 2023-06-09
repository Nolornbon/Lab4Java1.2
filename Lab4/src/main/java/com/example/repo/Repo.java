package com.example.repo;


import com.example.repo.entity.CalcResultEntity;

public interface Repo {

    Integer saveCalcResult(CalcResultEntity entity);

    CalcResultEntity getResultById(Integer id);
}
