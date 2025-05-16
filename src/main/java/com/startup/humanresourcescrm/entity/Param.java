package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Param")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paramId;
    private String code;
    private String description;
    private Long value;
}