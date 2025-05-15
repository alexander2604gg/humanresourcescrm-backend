package com.startup.humanresourcescrm.dto.role;

import com.startup.humanresourcescrm.dto.permission.PermissionResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoleResponseDto {
    private Long roleId;
    private String name;
    private List<PermissionResponseDto> permissionResponseDtos;
}
