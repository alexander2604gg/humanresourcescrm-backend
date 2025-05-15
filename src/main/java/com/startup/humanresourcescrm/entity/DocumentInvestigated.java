package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "document_investigated")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentInvestigated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumentInvestigated;
    private String name;
}
