package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;

import java.util.List;

public interface RoleService {
    RoleResponseDto save(RoleCreateDto roleCreateDto);

    List<RoleResponseDto> findAll();
}
