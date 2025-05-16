package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.BaseEntity;
import com.startup.humanresourcescrm.entity.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepository extends JpaRepository<BaseEntity , Long> {
    BaseEntity getByUserSec(UserSec userSec);
}
