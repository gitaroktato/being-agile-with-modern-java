package com.epam.agilespringboot.application;

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

    @Autowired
    private PersonToPersonDTOMapper mapper;

    @GetMapping("/v1/person/{id}")
    ResponseEntity<LegacyPersonDTO> findLegacyPersonById(@PathVariable String id) {
        final var person = personRepository.findById(Integer.valueOf(id));
        return person.map(result -> {
            var dto = mapper.personToLegacyPersonDTO(result);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(LegacyPersonDTO.NONE, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/person/{id}")
    ResponseEntity<PersonDTO> findPersonById(@PathVariable String id) {
        final var person = personRepository.findById(Integer.valueOf(id));
        return person.map(result -> {
            var dto = mapper.personToPersonDTO(result);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(PersonDTO.NONE, HttpStatus.NOT_FOUND));
    }
}