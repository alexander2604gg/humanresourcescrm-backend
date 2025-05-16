package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.mapper.RoleMapper;
import com.startup.humanresourcescrm.repository.RoleRepository;
import com.startup.humanresourcescrm.service.RolePermissionService;
import com.startup.humanresourcescrm.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final RolePermissionService rolePermissionService;

    @Override
    public RoleResponseDto save(RoleCreateDto roleCreateDto) {
        Role roleSaved = roleRepository.save(roleMapper.toEntityFromCreate(roleCreateDto));

        if (roleCreateDto.getPermissionIds() != null && !roleCreateDto.getPermissionIds().isEmpty()) {
            rolePermissionService.assignPermissionsToRole(roleSaved, roleCreateDto.getPermissionIds());
        }

        return roleMapper.toRoleResponseDto(roleSaved);
    }

    public List<RoleResponseDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.toRoleResponseDtoList(roles);
    }
}
