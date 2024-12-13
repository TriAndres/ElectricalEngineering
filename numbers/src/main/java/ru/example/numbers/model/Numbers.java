package ru.example.numbers.model;

import lombok.Builder;
import lombok.Data;
import ru.example.numbers.validator.NonNullValidation;

@Data
@Builder
public class Numbers {
    private Long id;

    @NonNullValidation
    private Long num;
}