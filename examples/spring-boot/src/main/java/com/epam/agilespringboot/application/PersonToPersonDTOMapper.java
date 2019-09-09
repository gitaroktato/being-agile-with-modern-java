package com.epam.agilespringboot.application;

import com.epam.agilespringboot.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonToPersonDTOMapper {

    @Mapping(target = "fullName", expression =
    "java(person.getFirstName() + \" \" + person.getLastName())")
    LegacyPersonDTO personToLegacyPersonDTO(Person person);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    PersonDTO personToPersonDTO(Person person);
}
