package com.startup.humanresourcescrm.controller;

import com.startup.humanresourcescrm.dto.param.ParamCreateDto;
import com.startup.humanresourcescrm.dto.param.ParamResponseDto;
import com.startup.humanresourcescrm.dto.param.ParamUpdateDto;
import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.service.impl.ParamServiceImpl;
import com.startup.humanresourcescrm.service.impl.RoleServiceImpl;
import com.startup.humanresourcescrm.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/param")
@AllArgsConstructor
public class ParamController {
    private final ParamServiceImpl paramService;

    @PostMapping
    public ResponseEntity<ApiResponse<ParamResponseDto>> createParam(ParamCreateDto paramCreateDto) {
        ParamResponseDto paramResponseDto = paramService.save(paramCreateDto);
        return ResponseEntity.ok(new ApiResponse<>("Param created successfully", paramResponseDto));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ParamResponseDto>> updateParam(ParamUpdateDto paramUpdateDto) {
        ParamResponseDto paramResponseDto = paramService.update(paramUpdateDto);
        return ResponseEntity.ok(new ApiResponse<>("Param updated successfully", paramResponseDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ParamResponseDto>>> getallParams() {
        List<ParamResponseDto> paramResponseDtos = paramService.findAll();
        return ResponseEntity.ok(new ApiResponse<>("Params retrieved successfully", paramResponseDtos));
    }
}
