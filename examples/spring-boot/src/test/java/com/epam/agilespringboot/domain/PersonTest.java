package com.epam.agilespringboot.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void getFirstName() {
        final var person = new Person();
        person.setFirstName("Bob");
        Assertions.assertThat(person.getFirstName()).isEqualTo("Bob");
    }
}