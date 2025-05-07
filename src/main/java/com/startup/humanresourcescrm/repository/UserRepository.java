package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserSec , Long> {
    Optional<UserSec> findUserSecByEmail(String email);
}
