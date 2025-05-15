package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.permission.PermissionCreateDto;
import com.startup.humanresourcescrm.dto.permission.PermissionResponseDto;
import com.startup.humanresourcescrm.entity.Permission;
import com.startup.humanresourcescrm.entity.RolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    @Mapping(target = "permissionId" , ignore = true)
    Permission toEntityFromCreate (PermissionCreateDto permissionCreateDto);
    PermissionResponseDto toPermissionResponseDto(Permission permission);
    @Mapping(target = "permissionId" , source = "permission.permissionId")
    @Mapping(target = "name" , source = "permission.name")
    PermissionResponseDto toPermissionResponseDto (RolePermission rolePermission);
    List<PermissionResponseDto> toPermissionResponseDtoList(List<Permission> permission);
}
