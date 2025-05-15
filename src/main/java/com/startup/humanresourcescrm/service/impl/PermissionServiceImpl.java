package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.permission.PermissionCreateDto;
import com.startup.humanresourcescrm.dto.permission.PermissionResponseDto;
import com.startup.humanresourcescrm.entity.Permission;
import com.startup.humanresourcescrm.mapper.PermissionMapper;
import com.startup.humanresourcescrm.repository.PermissionRepository;
import com.startup.humanresourcescrm.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionResponseDto save(PermissionCreateDto permissionCreateDto) {
        Permission permissionSaved = permissionRepository.save(permissionMapper.toEntityFromCreate(permissionCreateDto));
        return permissionMapper.toPermissionResponseDto(permissionSaved);
    }

    public List<PermissionResponseDto> findAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream()
                .map(permissionMapper::toPermissionResponseDto)
                .toList();
    }
}
