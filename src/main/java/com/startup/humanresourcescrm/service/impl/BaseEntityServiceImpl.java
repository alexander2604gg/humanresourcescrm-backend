package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.entity.EntityCompanyCreateDto;
import com.startup.humanresourcescrm.dto.entity.EntityPersonCreateDto;
import com.startup.humanresourcescrm.dto.requestinvestigated.RequestCreateDto;
import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserEntityCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.entity.BaseEntity;
import com.startup.humanresourcescrm.entity.RequestInvestigated;
import com.startup.humanresourcescrm.entity.UserSec;
import com.startup.humanresourcescrm.enums.EntityType;
import com.startup.humanresourcescrm.factory.UserCreateDtoFactory;
import com.startup.humanresourcescrm.mapper.EntityMapper;
import com.startup.humanresourcescrm.mapper.UserMapper;
import com.startup.humanresourcescrm.repository.BaseEntityRepository;
import com.startup.humanresourcescrm.service.BaseEntityService;
import com.startup.humanresourcescrm.service.RequestInvestigatedService;
import com.startup.humanresourcescrm.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class BaseEntityServiceImpl implements BaseEntityService {

    private final UserService userService;
    private final RequestInvestigatedService requestInvestigatedService;
    private final BaseEntityRepository baseEntityRepository;
    private final EntityMapper entityMapper;
    private final EmailServiceImpl emailService;
    private final UserCreateDtoFactory userCreateDtoFactory;

    @Override
    public void saveEntityCompany(EntityCompanyCreateDto entityCompanyCreateDto) {
        BaseEntity baseEntity = entityMapper.toEntityFromCompanyCreateDto(entityCompanyCreateDto);
        baseEntity.setEntityType(EntityType.COMPANY);
        UserEntityCreateDto userEntityCreateDto = entityCompanyCreateDto.getUserEntityCreateDto();
        String password = entityCompanyCreateDto.getRuc();
        UserCreateDto userCreateDto = userCreateDtoFactory.fromUserEntityCompanyCreateDto(userEntityCreateDto, password);
        UserResponseDto userResponseDto = userService.save(userCreateDto);

        UserSec userSec = UserSec.builder()
                .userId(userResponseDto.getUserId())
                .build();
        baseEntity.setUserSec(userSec);
        BaseEntity savedEntity = baseEntityRepository.save(baseEntity);

        // Temporal: Generar RequestInvestigated (ÚNICO) para almacenar Candidatos por Empresa
        RequestCreateDto requestCreateDto = new RequestCreateDto();
        requestCreateDto.setEntityId(savedEntity.getIdBaseEntity());
        requestInvestigatedService.create(requestCreateDto);

        // Envio de email con la contraseña al usuario
        emailService.sendPasswordToClient(userCreateDto.getEmail(),password);
    }

    @Override
    public void saveEntityPersona(EntityPersonCreateDto entityPersonCreateDto) {
        BaseEntity baseEntity = entityMapper.toEntityFromPersonCreateDto(entityPersonCreateDto);
        baseEntity.setEntityType(EntityType.PERSON);
        UserEntityCreateDto userEntityCreateDto = entityPersonCreateDto.getUserEntityCreateDto();
        String password = entityPersonCreateDto.getDni();
        UserCreateDto userCreateDto = userCreateDtoFactory.fromUserEntityPersonCreateDto(userEntityCreateDto, password);
        UserResponseDto userResponseDto = userService.save(userCreateDto);
        UserSec userSec = UserSec.builder()
                .userId(userResponseDto.getUserId())
                .build();
        baseEntity.setUserSec(userSec);
        baseEntityRepository.save(baseEntity);
        emailService.sendPasswordToClient(userCreateDto.getEmail(),password);
    }





}
