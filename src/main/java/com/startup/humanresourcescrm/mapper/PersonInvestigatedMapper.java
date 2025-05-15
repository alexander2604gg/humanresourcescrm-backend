package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.requestinvestigated.PersonToInvestigateCreateDto;
import com.startup.humanresourcescrm.entity.PersonInvestigated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonInvestigatedMapper {
    @Mapping(target = "idPersonInvestigated" , ignore = true)
    @Mapping(target = "requestInvestigated" , ignore = true)
    PersonInvestigated toEntityFromCreate (PersonToInvestigateCreateDto personToInvestigateCreateDto);
    List<PersonInvestigated> toEntityListFromCreate(List<PersonToInvestigateCreateDto> personToInvestigateCreateDtoList);

}
