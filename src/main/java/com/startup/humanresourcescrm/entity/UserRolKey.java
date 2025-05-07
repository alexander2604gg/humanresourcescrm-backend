package com.startup.humanresourcescrm.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRolKey implements Serializable {
    @Column(name = "user_id")
    Long userId;
    @Column(name = "role_id")
    Long roleId;
}
