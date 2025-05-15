package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.DocumentInvestigated;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentInvestigatedRepository extends CrudRepository<DocumentInvestigated , Long> {
}
