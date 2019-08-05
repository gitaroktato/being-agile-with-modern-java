package com.epam.agilespringboot.infrastructure;

import com.epam.agilespringboot.domain.Person;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PersonRepository extends Repository<Person, Integer> {

    Optional<Person> findById(Integer id);
}
