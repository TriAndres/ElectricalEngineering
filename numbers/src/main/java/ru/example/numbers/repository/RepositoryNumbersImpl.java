package ru.example.numbers.repository;

import ru.example.numbers.model.Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryNumbersImpl implements RepositoryNumbers {
    private final Map<Long, Numbers> numbersMap = new HashMap<>();

    @Override
    public List<Numbers> findAll() {
        return new ArrayList<>(numbersMap.values());
    }

    @Override
    public Numbers save(Numbers numbers) {
        return numbersMap.put(numbers.getId(), numbers);
    }

    @Override
    public Numbers findById(long id) {
        return numbersMap.get(id);
    }

    @Override
    public void deleteById(long id) {
        numbersMap.remove(id);
    }
}