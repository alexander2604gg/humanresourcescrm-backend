package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.requestinvestigated.RequestCreateDto;
import com.startup.humanresourcescrm.entity.RequestInvestigated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequestInvestigatedMapper {
    @Mapping(target = "idRequestInvestigated" , ignore = true)
    @Mapping(target = "baseEntity.idBaseEntity" , source = "entityId")
    RequestInvestigated toEntityFromCreate (RequestCreateDto requestCreateDto);
}
