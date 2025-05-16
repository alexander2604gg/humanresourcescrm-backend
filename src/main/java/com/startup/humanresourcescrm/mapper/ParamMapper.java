package com.startup.humanresourcescrm.mapper;

import com.startup.humanresourcescrm.dto.param.ParamCreateDto;
import com.startup.humanresourcescrm.dto.param.ParamResponseDto;
import com.startup.humanresourcescrm.dto.param.ParamUpdateDto;
import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.entity.Param;
import com.startup.humanresourcescrm.entity.Role;
import com.startup.humanresourcescrm.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParamMapper {
    @Mapping(target = "paramId" , ignore = true)
    Param toEntityFromCreate (ParamCreateDto paramCreateDto);
    Param toEntityFromUpdate (ParamUpdateDto paramUpdateDto);
    ParamResponseDto toParamResponseDto(Param param);
    List<ParamResponseDto> toParamResponseDtoList(List<Param> paramList);
}
