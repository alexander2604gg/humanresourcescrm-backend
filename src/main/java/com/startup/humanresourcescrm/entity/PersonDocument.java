package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "person_document")
@NoArgsConstructor
@AllArgsConstructor
public class PersonDocument {
    @Id
    private PersonDocumentKey personDocumentKey;

    @ManyToOne
    @MapsId("idPersonInvestigated")
    @JoinColumn(name = "idPersonInvestigated")
    private PersonInvestigated personInvestigated;

    @ManyToOne
    @MapsId("idDocumentInvestigated")
    @JoinColumn(name = "idDocumentInvestigated")
    private DocumentInvestigated documentInvestigated;

    private Boolean state;

}
