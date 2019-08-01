package com.epam.agilespringboot.application;

import com.epam.agilespringboot.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    @GetMapping("/person/{id}")
    Mono<Person> findById(@PathVariable String id) {
        var person = new Person(1, "John", "Smith");
        return Mono.just(person);
    }
}
