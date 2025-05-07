package com.startup.humanresourcescrm.enums;

import lombok.Getter;

@Getter
public enum EntityType {
    PERSON("Person"),
    COMPANY("Company");

    private final String description;

    EntityType(String description) {
        this.description = description;
    }
}
