package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.entity.EntityCompanyCreateDto;
import com.startup.humanresourcescrm.dto.entity.EntityPersonCreateDto;
import com.startup.humanresourcescrm.entity.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    @Mapping(target = "dni", ignore = true)
    @Mapping(target = "entityType" , ignore = true)
    @Mapping(target = "idBaseEntity" , ignore = true)
    @Mapping(target = "firstName" , ignore = true)
    @Mapping(target = "lastName" , ignore = true)
    @Mapping(target = "userSec" , ignore = true)
    BaseEntity toEntityFromCompanyCreateDto (EntityCompanyCreateDto entityCompanyCreateDto);
    @Mapping(target = "idBaseEntity" , ignore = true)
    @Mapping(target = "businessName" , ignore = true)
    @Mapping(target = "entityType" , ignore = true)
    @Mapping(target = "ruc" , ignore = true)
    @Mapping(target = "userSec" , ignore = true)
    BaseEntity toEntityFromPersonCreateDto (EntityPersonCreateDto entityPersonCreateDto);
}
