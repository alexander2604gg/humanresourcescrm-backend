package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.entity.RolePermission;
import com.startup.humanresourcescrm.entity.UserRole;
import com.startup.humanresourcescrm.entity.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    @Query("SELECT ur FROM UserRole ur WHERE ur.userSec = :userSec")
    List<UserRole> findByUserSec(@Param("userSec") UserSec userSec);
}
