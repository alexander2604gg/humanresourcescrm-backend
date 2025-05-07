package com.startup.humanresourcescrm.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {
    public String email;
    public String jwt;
}
