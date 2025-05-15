package com.startup.humanresourcescrm.factory;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserEntityCreateDto;
import org.springframework.stereotype.Component;

@Component
public class UserCreateDtoFactory {
    public UserCreateDto fromUserEntityCreateDto(UserEntityCreateDto userEntityCreateDto , String password) {
        return UserCreateDto
                .builder()
                .email(userEntityCreateDto.getEmail())
                .password(password)
                .build();

    }
}
