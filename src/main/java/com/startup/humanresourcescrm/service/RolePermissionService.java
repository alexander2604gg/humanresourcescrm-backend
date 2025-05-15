package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.entity.Role;

import java.util.List;

public interface RolePermissionService {
    void assignPermissionsToRole(Role role, List<Long> permissionIds);
}
