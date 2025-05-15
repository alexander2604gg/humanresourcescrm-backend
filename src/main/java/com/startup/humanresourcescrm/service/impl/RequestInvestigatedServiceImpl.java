package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.requestinvestigated.RequestCreateDto;
import com.startup.humanresourcescrm.entity.PersonInvestigated;
import com.startup.humanresourcescrm.entity.RequestInvestigated;
import com.startup.humanresourcescrm.mapper.PersonInvestigatedMapper;
import com.startup.humanresourcescrm.mapper.RequestInvestigatedMapper;
import com.startup.humanresourcescrm.repository.RequestInvestigatedRepository;
import com.startup.humanresourcescrm.service.RequestInvestigatedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestInvestigatedServiceImpl implements RequestInvestigatedService {

    private final RequestInvestigatedRepository requestInvestigatedRepository;
    private final RequestInvestigatedMapper requestInvestigatedMapper;
    private final PersonInvestigatedMapper personInvestigatedMapper;

    @Override
    public void create(RequestCreateDto requestCreateDto) {
        RequestInvestigated requestInvestigated = requestInvestigatedMapper.toEntityFromCreate(requestCreateDto);
        List<PersonInvestigated> personInvestigatedList = personInvestigatedMapper.toEntityListFromCreate(requestCreateDto.getPersonsToInvestigate());
        RequestInvestigated requestInvestigatedRegistered = requestInvestigatedRepository.save(requestInvestigated);
        for (PersonInvestigated personInvestigated : personInvestigatedList){
            personInvestigated.setRequestInvestigated(requestInvestigatedRegistered);
        }
    }
}
