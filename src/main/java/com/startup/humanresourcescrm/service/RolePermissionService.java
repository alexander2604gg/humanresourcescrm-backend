package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.entity.Permission;
import com.startup.humanresourcescrm.entity.Role;

import java.util.List;
import java.util.Set;

public interface RolePermissionService {
    void assignPermissionsToRole(Role role, List<Long> permissionIds);

    Set<Permission> getPermissionsByRole(Role role);
}
