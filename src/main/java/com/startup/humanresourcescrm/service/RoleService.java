package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;

import java.util.List;

public interface RoleService {
    RoleResponseDto save(RoleCreateDto roleCreateDto);

    public List<RoleResponseDto> findAll();
}
