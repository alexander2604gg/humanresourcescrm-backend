package com.startup.humanresourcescrm.factory;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserEntityCreateDto;
import com.startup.humanresourcescrm.entity.Param;
import com.startup.humanresourcescrm.enums.EnumParam;
import com.startup.humanresourcescrm.repository.ParamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserCreateDtoFactory {
    private final ParamRepository paramRepository;

    public UserCreateDto fromUserEntityCreateDtoGeneric(UserEntityCreateDto userEntityCreateDto , String password) {


        return UserCreateDto
                .builder()
                .email(userEntityCreateDto.getEmail())
                .password(password)
                .build();

    }

    public UserCreateDto fromUserEntityCompanyCreateDto(UserEntityCreateDto userEntityCreateDto , String password) {
        UserCreateDto userCreateDto = fromUserEntityCreateDtoGeneric(userEntityCreateDto, password);

        List<Long> rolesIds = getRolesIdsByParam(EnumParam.COMPANY_ENTITY_ROLE_DEFAULT);
        userCreateDto.setRoleIds(rolesIds);

        userCreateDto.setRoleIds(rolesIds);

        return userCreateDto;
    }

    public UserCreateDto fromUserEntityPersonCreateDto(UserEntityCreateDto userEntityCreateDto , String password) {
        UserCreateDto userCreateDto = fromUserEntityCreateDtoGeneric(userEntityCreateDto, password);

        List<Long> rolesIds = getRolesIdsByParam(EnumParam.PERSON_ENTITY_ROLE_DEFAULT);
        userCreateDto.setRoleIds(rolesIds);

        return userCreateDto;
    }

    public List<Long> getRolesIdsByParam(EnumParam enumParam) {
        List<Long> rolesIds = new ArrayList<>();
        Optional<Param> paramOptional = paramRepository.findByCode(enumParam.getValue());
        paramOptional.ifPresent(param -> rolesIds.add(param.getValue()));

        return rolesIds;
    }
}
