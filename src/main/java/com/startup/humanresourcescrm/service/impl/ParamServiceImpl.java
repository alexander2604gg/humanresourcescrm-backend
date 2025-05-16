package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.param.ParamCreateDto;
import com.startup.humanresourcescrm.dto.param.ParamResponseDto;
import com.startup.humanresourcescrm.dto.param.ParamUpdateDto;
import com.startup.humanresourcescrm.entity.Param;
import com.startup.humanresourcescrm.mapper.ParamMapper;
import com.startup.humanresourcescrm.repository.ParamRepository;
import com.startup.humanresourcescrm.service.ParamService;
import com.startup.humanresourcescrm.util.CodeParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ParamServiceImpl implements ParamService {

    private final ParamRepository paramRepository;
    private final ParamMapper paramMapper;
    private final CodeParam codeParam;

    @Override
    public ParamResponseDto save(ParamCreateDto paramCreateDto) {
        Param param = paramMapper.toEntityFromCreate(paramCreateDto);
        param.setCode(codeParam.generate());
        Param paramSaved = paramRepository.save(param);
        return paramMapper.toParamResponseDto(paramSaved);
    }

    public ParamResponseDto update(ParamUpdateDto paramUpdateDto) {
        Param paramSaved = paramRepository.save(paramMapper.toEntityFromUpdate(paramUpdateDto));
        return paramMapper.toParamResponseDto(paramSaved);
    }

    public List<ParamResponseDto> findAll() {
        List<Param> params = paramRepository.findAll();
        return paramMapper.toParamResponseDtoList(params);
    }
}
