package com.startup.humanresourcescrm.dto.user;

import com.startup.humanresourcescrm.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserResponseDto {
    private Long userId;
    private String email;
    private Set<Role> roles;
}
