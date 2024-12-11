package ru.example.numbers.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Numbers {
    private Long id;
    private Long num;
}
