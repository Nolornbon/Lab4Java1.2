package com.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Data
public class Step {
        private int step;
        private String quotient;
        private String remainder;
        public Step(int step, String quotient, String remainder) {
                this.step = step;
                this.quotient = quotient;
                this.remainder = remainder;
        }
}
