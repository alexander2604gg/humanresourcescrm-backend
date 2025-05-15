package com.startup.humanresourcescrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Role_Permission")
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission {
    @EmbeddedId
    RolePermissionKey id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    Role role;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    Permission permission;
}
