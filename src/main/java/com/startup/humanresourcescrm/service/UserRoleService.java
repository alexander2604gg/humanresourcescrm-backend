package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.entity.UserSec;

import java.util.List;

public interface UserRoleService {
    void assignRolesToUser(UserSec userSec, List<Long> roleIds);
}
