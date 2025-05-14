package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.entity.UserSec;

import java.util.List;
import java.util.Set;

public interface UserRoleService {
    void assignRolesToUser(UserSec userSec, List<Long> roleIds);

    Set<Role> getPermissionsByUser(UserSec user);
}
