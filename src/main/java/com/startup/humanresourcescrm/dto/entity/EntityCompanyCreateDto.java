package com.startup.humanresourcescrm.dto.entity;
import com.startup.humanresourcescrm.dto.user.UserEntityCreateDto;
import lombok.Data;

@Data
public class EntityCompanyCreateDto {
    private String businessName;
    private String ruc;
    private String address;
    private String phone;
    private UserEntityCreateDto userEntityCreateDto;
}
