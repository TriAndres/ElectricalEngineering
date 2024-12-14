package ru.example.numbers.service.numberService;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.numbers.model.Numbers;

public interface NumberServiceDb extends JpaRepository<Numbers, Long> {
}
