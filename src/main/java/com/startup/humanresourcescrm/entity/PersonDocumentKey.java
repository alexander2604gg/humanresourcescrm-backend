package com.startup.humanresourcescrm.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PersonDocumentKey {
    private Long idPersonInvestigated;
    private Long idDocumentInvestigated;
}
