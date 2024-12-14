package ru.example.numbers.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.numbers.model.Numbers;
import ru.example.numbers.service.numberService.NumbersServiceImpl;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/numbers")
@RequiredArgsConstructor
@Slf4j
public class NumbersController {
    private final NumbersServiceImpl service;

    @GetMapping
    public ResponseEntity<Collection<Numbers>> findAll() {
        log.info("findAll()");
        return  new ResponseEntity<>(service.findAll(), HttpStatus.valueOf(200));
    }

    @PostMapping()
    public ResponseEntity<Numbers> create(@Valid @RequestBody Numbers numbers) {
        log.info("create(Numbers numbers)");
        return new ResponseEntity<>(service.create(numbers), HttpStatus.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<Numbers> update(@Valid @RequestBody Numbers newNumbers) {
        log.info("update(Numbers newNumbers)");
        return new ResponseEntity<>(service.update(newNumbers), HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Numbers>> findById(@PathVariable long id) {
        log.info("findById(long id)");
        return new ResponseEntity<>(service.findById(id), HttpStatus.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable long id) {
        log.info("deleteId(long id)");
        service.deleteId(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}