package com.startup.humanresourcescrm.service;

import com.startup.humanresourcescrm.dto.requestinvestigated.RequestCreateDto;
import com.startup.humanresourcescrm.dto.requestinvestigated.RequestResponseDto;

import java.util.List;

public interface RequestInvestigatedService {
    public void create(RequestCreateDto requestCreateDto);
    public List<RequestResponseDto> findAll();
}
