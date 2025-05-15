package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.permission.PermissionCreateDto;
import com.startup.humanresourcescrm.dto.permission.PermissionResponseDto;
import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.entity.Permission;
import com.startup.humanresourcescrm.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    @Mapping(target = "permissionId" , ignore = true)
    Permission toEntityFromCreate (PermissionCreateDto permissionCreateDto);
    PermissionResponseDto toPermissionResponseDto(Permission permission);
}
