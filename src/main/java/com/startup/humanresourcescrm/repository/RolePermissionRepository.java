package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission,Long> {
    @Query("SELECT rp FROM RolePermission rp WHERE rp.role = :role")
    List<RolePermission> findByRole(@Param("role") Role role);
}
