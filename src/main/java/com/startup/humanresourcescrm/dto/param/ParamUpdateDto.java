package com.startup.humanresourcescrm.dto.param;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParamUpdateDto {
    private Long paramId;
    private String description;
    private Long value;
}
