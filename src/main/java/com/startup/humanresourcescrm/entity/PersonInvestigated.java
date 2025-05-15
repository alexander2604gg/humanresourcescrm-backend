package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person_investigated")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInvestigated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonInvestigated;
    private String dni;
    private String firstName;
    private String secondName;
    private String phone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_request_investigated", nullable = false)
    private RequestInvestigated requestInvestigated;
}
