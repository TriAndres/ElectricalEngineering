package ru.example.numbers.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.numbers.service.NumbersServiceImpl;

@RestController
@RequestMapping("numbers")
@RequiredArgsConstructor
@Slf4j
public class NumbersController {
    private final NumbersServiceImpl service;
}
