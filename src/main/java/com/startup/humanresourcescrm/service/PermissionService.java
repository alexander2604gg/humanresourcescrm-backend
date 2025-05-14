package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.permission.PermissionCreateDto;
import com.startup.humanresourcescrm.dto.permission.PermissionResponseDto;

import java.util.List;

public interface PermissionService {
    public PermissionResponseDto save(PermissionCreateDto permissionCreateDto);

    public List<PermissionResponseDto> findAll();
}
