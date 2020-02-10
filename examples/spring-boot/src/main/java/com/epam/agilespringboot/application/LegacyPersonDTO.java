package com.epam.agilespringboot.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class LegacyPersonDTO {
    @Getter @Setter
    private String fullName;
    public static final LegacyPersonDTO NONE = new LegacyPersonDTO();
}
