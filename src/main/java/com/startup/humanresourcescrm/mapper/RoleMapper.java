package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.entity.RolePermission;
import com.startup.humanresourcescrm.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring" , uses = {PermissionMapper.class})
public interface RoleMapper {
    @Mapping(target = "roleId" , ignore = true)
    Role toEntityFromCreate (RoleCreateDto roleCreateDto);
    @Mapping(source = "permissions" , target = "permissionResponseDtos")
    RoleResponseDto toRoleResponseDto(Role role);
    @Mapping(target = "roleId" , source = "role.roleId")
    @Mapping(target = "name" , source = "role.name")
    @Mapping(target = "permissionResponseDtos" , source="role.permissions")
    RoleResponseDto toRoleResponseDto (UserRole userRole);
    List<RoleResponseDto> toRoleResponseDtoList(List<Role> roles);
}
