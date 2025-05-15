package com.startup.humanresourcescrm.dto.role;

import com.startup.humanresourcescrm.entity.Permission;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class RoleResponseDto {
    private Long roleId;
    private String name;
    private Set<Permission> permissions;
}
