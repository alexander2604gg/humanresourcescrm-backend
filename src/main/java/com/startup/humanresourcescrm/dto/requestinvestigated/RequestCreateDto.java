package com.startup.humanresourcescrm.dto.requestinvestigated;

import lombok.Data;

import java.util.List;

@Data
public class RequestCreateDto {
    private Long entityId;
    List<PersonToInvestigateCreateDto> personsToInvestigate;
}
