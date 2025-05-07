package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "User_Rol")
@NoArgsConstructor
@AllArgsConstructor
public class UserRol {
    @EmbeddedId
    UserRolKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserSec userSec;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    Rol rol;
}
