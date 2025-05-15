package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "request_investigated")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestInvestigated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequestInvestigated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_base_entity", nullable = false)
    private BaseEntity baseEntity;
}
