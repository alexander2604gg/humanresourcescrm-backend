package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.entity.EntityCompanyCreateDto;
import com.startup.humanresourcescrm.dto.entity.EntityPersonCreateDto;

public interface BaseEntityService {
    void saveEntityCompany (EntityCompanyCreateDto entityCompanyCreateDto);
    void saveEntityPersona(EntityPersonCreateDto entityPersonCreateDto);
}
