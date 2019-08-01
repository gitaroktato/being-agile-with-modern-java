package com.epam.agilespringboot.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Person {
    @NonNull @Getter private Integer id;
    @NonNull @Getter  private String firstName;
    @NonNull @Getter  private String lastName;

}
