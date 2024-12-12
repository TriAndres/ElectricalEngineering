package ru.example.numbers.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.example.numbers.exception.NumbersDoesNotExistException;
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
        numbers.setId(getNextId());
        repository.save(numbers);
        log.info("Записано число с id={}.",numbers.getId());
        return numbers;
    }

    @Override
    public Numbers update(Numbers newNumbers) {
        if (repository.findById(newNumbers.getId()).getId().equals(newNumbers.getId())) {
            Numbers old = repository.findById(newNumbers.getId());
            old.setNum(newNumbers.getNum());
            repository.save(old);
            log.info("Обновлено число с id={}.",old.getId());
            return old;
        }
        log.info("Ошибка при обновлении");
        throw new NumbersDoesNotExistException("Число отсутствует.");
    }

    @Override
    public Optional<Numbers> findById(long id) {
        if (repository.findAll().contains(repository.findById(id))) {
            log.info("Возврат по id={}", id);
            return Optional.ofNullable(repository.findById(id));
        }
        log.info("Число c id={} отсутствует", id);
        throw new NumbersDoesNotExistException("Число отсутствует.");
    }

    @Override
    public void deleteId(long id) {
        if (repository.findAll().contains(repository.findById(id))) {
            repository.deleteById(id);
            log.info("Удаление числа с id={}",id);
        }
        log.info("Число c id={} отсутствует", id);
        throw new NumbersDoesNotExistException("Число отсутствует.");
    }

    private long getNextId() {
        long currentMaxId = repository.findAll()
                .stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}