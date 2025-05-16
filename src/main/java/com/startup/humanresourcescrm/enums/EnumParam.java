package com.startup.humanresourcescrm.enums;

import lombok.Getter;

@Getter
public enum EnumParam {
    COMPANY_ENTITY_ROLE_DEFAULT("P001"),
    PERSON_ENTITY_ROLE_DEFAULT("P002");

    private final String value;

    EnumParam(String value) {
        this.value = value;
    }
}

