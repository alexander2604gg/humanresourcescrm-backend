package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.Param;
import com.startup.humanresourcescrm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParamRepository extends JpaRepository<Param,Long> {
    @Query("SELECT p.code FROM Param p ORDER BY p.paramId DESC LIMIT 1")
    String findLastCode();

    Optional<Param> findByCode(String code);
}
