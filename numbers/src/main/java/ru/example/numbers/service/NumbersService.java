package ru.example.numbers.service;

import ru.example.numbers.model.Numbers;

import java.util.Collection;
import java.util.Optional;

public interface NumbersService {
    Collection<Numbers> findAll();

    Numbers create(Numbers numbers);

    Numbers update(Numbers newNumbers);

    Optional<Numbers> findById(long id);

    void deleteId(long id);
}