package com.startup.humanresourcescrm.dto.role;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoleCreateDto {
    private String name;
    private List<Long> permissionIds;
}
