package com.startup.humanresourcescrm.entity;

import com.startup.humanresourcescrm.enums.EntityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBaseEntity;
    @Enumerated(EnumType.STRING)
    private EntityType entityType;
    private String firstName;
    private String lastName;
    private String dni;

    @Column(name = "business_name")
    private String businessName;
    private String ruc;

    private String address;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserSec userSec;

}