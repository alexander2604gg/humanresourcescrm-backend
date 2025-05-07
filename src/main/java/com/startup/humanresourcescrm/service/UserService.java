package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;

public interface UserService {
    public UserResponseDto save(UserCreateDto userCreateDto);
}
