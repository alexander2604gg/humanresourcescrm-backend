package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.RequestInvestigated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestInvestigatedRepository extends JpaRepository<RequestInvestigated , Long> {
}
