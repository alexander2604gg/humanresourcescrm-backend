package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.param.ParamCreateDto;
import com.startup.humanresourcescrm.dto.param.ParamResponseDto;
import com.startup.humanresourcescrm.dto.param.ParamUpdateDto;

import java.util.List;

public interface ParamService {
    ParamResponseDto save(ParamCreateDto paramCreateDto);

    ParamResponseDto update(ParamUpdateDto paramUpdateDto);

    List<ParamResponseDto> findAll();
}
