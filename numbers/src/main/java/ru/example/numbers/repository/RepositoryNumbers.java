package ru.example.numbers.repository;

import ru.example.numbers.model.Numbers;

import java.util.List;
import java.util.Map;

public interface RepositoryNumbers {
    List<Numbers> findAll();
    Numbers save(Numbers numbers);
    Numbers findById(long id);
    void deleteById(long id);
}
