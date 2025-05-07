package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Rol_Permission")
@NoArgsConstructor
@AllArgsConstructor
public class RolPermission {
    @EmbeddedId
    RolPermissionKey id;
    @ManyToOne
    @MapsId("rolId")
    @JoinColumn(name = "rol_id")
    Rol rol;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    Permission permission;
}
