package com.startup.humanresourcescrm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionKey implements Serializable{
    @Column(name = "role_id")
    Long roleId;
    @Column(name = "permission_id")
    Long permissionId;
}
