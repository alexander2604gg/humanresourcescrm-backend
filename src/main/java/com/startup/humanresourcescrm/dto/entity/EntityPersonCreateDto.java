package com.startup.humanresourcescrm.dto.entity;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserEntityCreateDto;
import lombok.Data;

@Data
public class EntityPersonCreateDto {
    private String firstName;
    private String lastName;
    private String dni;
    private String address;
    private String phone;
    UserEntityCreateDto userEntityCreateDto;
}
