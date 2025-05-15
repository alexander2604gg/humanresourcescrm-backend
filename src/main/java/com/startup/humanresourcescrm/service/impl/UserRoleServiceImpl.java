package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.entity.*;
import com.startup.humanresourcescrm.repository.RoleRepository;
import com.startup.humanresourcescrm.repository.UserRoleRepository;
import com.startup.humanresourcescrm.service.RolePermissionService;
import com.startup.humanresourcescrm.service.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public void assignRolesToUser(UserSec userSec, List<Long> rolesIds) {
        List<Role> roles = roleRepository.findAllById(rolesIds);

        if (roles.size() != rolesIds.size()) {
            Set<Long> foundIds = roles.stream()
                    .map(Role::getRoleId)
                    .collect(Collectors.toSet());

            List<Long> notFound = rolesIds.stream()
                    .filter(id -> !foundIds.contains(id))
                    .toList();

            throw new RuntimeException("Los siguientes permissionIds no existen: " + notFound);
        }

        List<UserRole> userRoles = roles.stream().map(role -> {
            UserRoleKey key = new UserRoleKey(userSec.getUserId(), role.getRoleId());
            return new UserRole(key, userSec, role);
        }).toList();

        userRoleRepository.saveAll(userRoles);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> getPermissionsByUser(UserSec userSec) {
        return userRoleRepository.findByUserSec(userSec)
                .stream()
                .map(UserRole::getRole)
                .collect(Collectors.toSet());
    }
}