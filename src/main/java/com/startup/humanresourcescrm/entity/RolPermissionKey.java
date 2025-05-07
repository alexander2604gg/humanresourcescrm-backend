package com.startup.humanresourcescrm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RolPermissionKey implements Serializable{
    @Column(name = "rol_id")
    Long rolId;
    @Column(name = "permission_id")
    Long permissionId;
}
