package com.startup.humanresourcescrm.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleKey implements Serializable {
    @Column(name = "user_id")
    Long userId;
    @Column(name = "role_id")
    Long roleId;
}
