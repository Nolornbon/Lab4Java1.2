package com.example.controller;

import com.example.dto.CalculationInputDto;
import com.example.dto.CalculationOutputDto;
import com.example.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/calculations")
public class Controller {

    private final AppService appService;

    public Controller(AppService appService) {
        this.appService = appService;
    }

//  Отригінальний код (робоичий, але не повертає помилку)
    /*
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer calculate(@RequestBody CalculationInputDto calculationInputDto) {
        return demoService.calculate(calculationInputDto);
   }
*/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer calculate(@RequestBody CalculationInputDto calculationInputDto) {
        try {
            return appService.calculate(calculationInputDto);
        } catch (IllegalArgumentException e) {
            String errorMessage = "Invalid calculation input: " + e.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationOutputDto> getResults(@PathVariable("id") Integer id) {
        try {
            CalculationOutputDto result = appService.getResults(id);
            return ResponseEntity.ok(result);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getRawStatusCode()).body(null);
        }
    }
}