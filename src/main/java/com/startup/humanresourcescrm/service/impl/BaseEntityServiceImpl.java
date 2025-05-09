package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.entity.EntityCompanyCreateDto;
import com.startup.humanresourcescrm.dto.entity.EntityPersonCreateDto;
import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.entity.BaseEntity;
import com.startup.humanresourcescrm.entity.UserSec;
import com.startup.humanresourcescrm.enums.EntityType;
import com.startup.humanresourcescrm.mapper.EntityMapper;
import com.startup.humanresourcescrm.repository.BaseEntityRepository;
import com.startup.humanresourcescrm.service.BaseEntityService;
import com.startup.humanresourcescrm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BaseEntityServiceImpl implements BaseEntityService {

    private final UserService userService;
    private final BaseEntityRepository baseEntityRepository;
    private final EntityMapper entityMapper;
    private final EmailServiceImpl emailService;

    @Override
    public void saveEntityCompany(EntityCompanyCreateDto entityCompanyCreateDto) {
        BaseEntity baseEntity = entityMapper.toEntityFromCompanyCreateDto(entityCompanyCreateDto);
        baseEntity.setEntityType(EntityType.COMPANY);
        UserCreateDto userCreateDto = entityCompanyCreateDto.getUserCreateDto();
        String password = entityCompanyCreateDto.getRuc();
        userCreateDto.setPassword(password);
        UserResponseDto userResponseDto = userService.save(userCreateDto);
        UserSec userSec = UserSec.builder()
                .userId(userResponseDto.getUserId())
                .build();
        baseEntity.setUserSec(userSec);
        baseEntityRepository.save(baseEntity);
        emailService.sendPasswordToClient(userCreateDto.getEmail(),password);
    }

    @Override
    public void saveEntityPersona(EntityPersonCreateDto entityPersonCreateDto) {
        BaseEntity baseEntity = entityMapper.toEntityFromPersonCreateDto(entityPersonCreateDto);
        baseEntity.setEntityType(EntityType.PERSON);
        UserCreateDto userCreateDto = entityPersonCreateDto.getUserCreateDto();
        String password = entityPersonCreateDto.getDni();
        userCreateDto.setPassword(password);
        UserResponseDto userResponseDto = userService.save(userCreateDto);
        UserSec userSec = UserSec.builder()
                .userId(userResponseDto.getUserId())
                .build();
        baseEntity.setUserSec(userSec);
        baseEntityRepository.save(baseEntity);
        emailService.sendPasswordToClient(userCreateDto.getEmail(),password);
    }





}
