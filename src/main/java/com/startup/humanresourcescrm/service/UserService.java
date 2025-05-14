package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {
    public UserResponseDto save(UserCreateDto userCreateDto);

    public List<UserResponseDto> findAll();
}
