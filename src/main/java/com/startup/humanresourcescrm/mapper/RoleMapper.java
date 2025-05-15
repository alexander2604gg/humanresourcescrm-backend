package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "roleId" , ignore = true)
    Role toEntityFromCreate (RoleCreateDto roleCreateDto);
    RoleResponseDto toRoleResponseDto(Role role);
    List<RoleResponseDto> toRoleResponseDtoList(List<Role> roles);
}
