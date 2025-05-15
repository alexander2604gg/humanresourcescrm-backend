package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.entity.UserSec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class , PermissionMapper.class})
public interface UserMapper {
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "userId" , ignore = true)
    UserSec toEntityFromCreate (UserCreateDto userCreateDto);
    @Mapping(source = "roles" , target = "roleResponseDtos")
    UserResponseDto toUserLoggedDto (UserSec userSec);
    List<UserResponseDto> toUserSecResponseDtoList(List<UserSec> users);
}
