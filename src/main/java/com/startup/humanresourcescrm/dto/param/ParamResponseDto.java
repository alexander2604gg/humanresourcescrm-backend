package com.startup.humanresourcescrm.dto.param;

import com.startup.humanresourcescrm.dto.permission.PermissionResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParamResponseDto {
    private Long paramId;
    private String code;
    private String description;
    private Long value;
}
