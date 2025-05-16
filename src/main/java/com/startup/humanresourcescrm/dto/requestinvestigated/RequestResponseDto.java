package com.startup.humanresourcescrm.dto.requestinvestigated;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestResponseDto {
    private long requestId;
    private long entityId;
}
