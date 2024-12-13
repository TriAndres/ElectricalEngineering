package ru.example.numbers.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.example.numbers.model.Numbers;
import ru.example.numbers.service.NumbersServiceImpl;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/numbers")
@RequiredArgsConstructor
@Slf4j
public class NumbersController {
    private final NumbersServiceImpl service;

    @GetMapping
    public Collection<Numbers> findAll() {
        log.info("findAll()");
        return service.findAll();
    }

    @PostMapping()
    public Numbers create(@Valid @RequestBody Numbers numbers) {
        log.info("create(Numbers numbers)");
        return service.create(numbers);
    }

    @PutMapping
    public Numbers update(@Valid @RequestBody Numbers newNumbers) {
        log.info("update(Numbers newNumbers)");
        return service.update(newNumbers);
    }

    @GetMapping("/{id}")
    public Optional<Numbers> findById(@PathVariable long id) {
        log.info("findById(long id)");
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteId(@PathVariable long id) {
        log.info("deleteId(long id)");
        service.deleteId(id);
    }
}