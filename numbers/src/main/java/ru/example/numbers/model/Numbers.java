package ru.example.numbers.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Numbers {
    private Long id;
    @NonNull
    private Long num;
}