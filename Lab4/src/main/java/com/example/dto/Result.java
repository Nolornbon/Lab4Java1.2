package com.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@RequiredArgsConstructor
@Data
public class Result {
        private List<Step> steps;
        private String finalQuotient;
        private String finalRemainder;

        public Result(List<Step> steps) {
                this.steps = steps;
        }

        public void setFinalQuotient(String finalQuotient) {
                this.finalQuotient = finalQuotient;
        }
        public void setFinalRemainder(String finalRemainder) {
                this.finalRemainder = finalRemainder;
        }
}
