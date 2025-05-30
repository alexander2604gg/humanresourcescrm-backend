package com.startup.humanresourcescrm.dto.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserCreateDto {
    private String email;
    private String password;
    private List<Long> roleIds;
}
