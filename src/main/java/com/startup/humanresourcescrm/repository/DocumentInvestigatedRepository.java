package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.DocumentInvestigated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentInvestigatedRepository extends JpaRepository<DocumentInvestigated , Long> {
}
