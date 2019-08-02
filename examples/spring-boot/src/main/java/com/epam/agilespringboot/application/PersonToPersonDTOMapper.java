package com.epam.agilespringboot.application;

import com.epam.agilespringboot.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonToPersonDTOMapper {

    @Mapping(target = "fullName",
            expression = "java( person.getFirstName() + \" \" + person.getLastName() )")
    PersonDTO personToPersonDto(Person person);
}
