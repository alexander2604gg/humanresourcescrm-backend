package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.entity.UserSec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "userId" , ignore = true)
    @Mapping(target = "roles" , ignore = true)
    UserSec toEntityFromCreate (UserCreateDto userCreateDto);
    UserResponseDto toUserLoggedDto (UserSec userSec);
}
