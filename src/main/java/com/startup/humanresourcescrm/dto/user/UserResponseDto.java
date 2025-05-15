package com.startup.humanresourcescrm.dto.user;

import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {
    private Long userId;
    private String email;
    private List<RoleResponseDto> roleResponseDtos;
}
