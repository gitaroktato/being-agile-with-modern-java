package com.epam.agilespringboot.application;

import com.epam.agilespringboot.domain.Person;
import com.epam.agilespringboot.infrastructure.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person/{id}")
    ResponseEntity<Person> findById(@PathVariable String id) {
        final var person = personRepository.findById(Integer.valueOf(id));
        return person.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}