package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.RequestInvestigated;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestInvestigatedRepository extends CrudRepository<RequestInvestigated , Long> {
}
