package com.startup.humanresourcescrm.dto.user;

import lombok.Data;

@Data
public class AuthLoginRequestDto {
    String email;
    String password;
}
