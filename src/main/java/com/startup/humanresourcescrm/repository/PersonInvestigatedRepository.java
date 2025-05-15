package com.startup.humanresourcescrm.repository;

import com.startup.humanresourcescrm.entity.PersonInvestigated;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInvestigatedRepository extends CrudRepository<PersonInvestigated , Long> {
}
