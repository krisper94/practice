package ru.krisper.practice.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.krisper.practice.models.Transistor;

@Repository
@Transactional
public interface TransistorDao extends CrudRepository<Transistor, Integer> {
}
