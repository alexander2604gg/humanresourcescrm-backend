package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.entity.Permission;
import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.entity.RolePermission;
import com.startup.humanresourcescrm.entity.RolePermissionKey;
import com.startup.humanresourcescrm.repository.PermissionRepository;
import com.startup.humanresourcescrm.repository.RolePermissionRepository;
import com.startup.humanresourcescrm.service.RolePermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;

    @Override
    @Transactional
    public void assignPermissionsToRole(Role role, List<Long> permissionIds) {
        List<Permission> permissions = permissionRepository.findAllById(permissionIds);

        if (permissions.size() != permissionIds.size()) {
            Set<Long> foundIds = permissions.stream()
                    .map(Permission::getPermissionId)
                    .collect(Collectors.toSet());

            List<Long> notFound = permissionIds.stream()
                    .filter(id -> !foundIds.contains(id))
                    .toList();

            throw new RuntimeException("Los siguientes permissionIds no existen: " + notFound);
        }

        List<RolePermission> rolePermissions = permissions.stream().map(permission -> {
            RolePermissionKey key = new RolePermissionKey(role.getRoleId(), permission.getPermissionId());
            return new RolePermission(key, role, permission);
        }).toList();

        rolePermissionRepository.saveAll(rolePermissions);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Permission> getPermissionsByRole(Role role) {
        return rolePermissionRepository.findByRole(role)
                .stream()
                .map(RolePermission::getPermission)
                .collect(Collectors.toSet());
    }
}