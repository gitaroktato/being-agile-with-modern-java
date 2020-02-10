package com.epam.agilespringboot.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PersonDTO {
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    public static final PersonDTO NONE = new PersonDTO();
}
