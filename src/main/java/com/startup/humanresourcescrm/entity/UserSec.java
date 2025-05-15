package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "UserSec")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean enabled;
    @OneToMany(mappedBy = "userSec")
    Set<UserRole> roles;

}