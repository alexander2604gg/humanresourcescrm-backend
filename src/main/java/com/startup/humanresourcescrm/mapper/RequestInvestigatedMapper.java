package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.requestinvestigated.RequestCreateDto;
import com.startup.humanresourcescrm.dto.requestinvestigated.RequestResponseDto;
import com.startup.humanresourcescrm.entity.RequestInvestigated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestInvestigatedMapper {
    @Mapping(target = "idRequestInvestigated" , ignore = true)
    @Mapping(target = "baseEntity.idBaseEntity" , source = "entityId")
    RequestInvestigated toEntityFromCreate (RequestCreateDto requestCreateDto);
    @Mapping(target = "requestId" , source = "idRequestInvestigated")
    @Mapping(target = "entityId" , source = "baseEntity.idBaseEntity")
    RequestResponseDto toResponseFromEntity (RequestInvestigated requestInvestigated);
    List<RequestResponseDto> toRequestResponseDtoList(List<RequestInvestigated> requestInvestigatedList);
}
