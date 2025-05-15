package com.startup.humanresourcescrm.dto.requestinvestigated;

import lombok.Data;

import java.util.List;

@Data
public class PersonToInvestigateCreateDto {
    private String dni;
    private String firstName;
    private String secondName;
    private String phone;
    private List<DocumentDto> documentDto;
}
