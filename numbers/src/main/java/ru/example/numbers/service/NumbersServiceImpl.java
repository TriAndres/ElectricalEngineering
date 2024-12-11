package ru.example.numbers.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.example.numbers.model.Numbers;
import ru.example.numbers.repository.NumbersRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumbersServiceImpl implements NumbersService {
    private final NumbersRepositoryImpl repository;

    @Override
    public Collection<Numbers> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Numbers create(Numbers numbers) {
        return null;
    }

    @Override
    public Numbers update(Numbers newNumbers) {
        return null;
    }

    @Override
    public Optional<Numbers> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteId(long id) {

    }

    private Long getNextId() {
        long currentMaxId = repository.findAll()
                .stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
