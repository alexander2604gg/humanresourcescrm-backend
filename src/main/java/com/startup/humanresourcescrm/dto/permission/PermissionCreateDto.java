package com.startup.humanresourcescrm.dto.permission;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PermissionCreateDto {
    private String name;
}
