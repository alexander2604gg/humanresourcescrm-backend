package com.startup.humanresourcescrm.controller;

import com.startup.humanresourcescrm.dto.permission.PermissionCreateDto;
import com.startup.humanresourcescrm.dto.permission.PermissionResponseDto;
import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.service.impl.PermissionServiceImpl;
import com.startup.humanresourcescrm.service.impl.RoleServiceImpl;
import com.startup.humanresourcescrm.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
@AllArgsConstructor
public class PermissionController {

    private final PermissionServiceImpl permissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<PermissionResponseDto>> createPermission(PermissionCreateDto permissionCreateDto) {
        PermissionResponseDto permissionResponseDto = permissionService.save(permissionCreateDto);
        return ResponseEntity.ok(new ApiResponse<>("Permission created successfully", permissionResponseDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PermissionResponseDto>>> getAllPermissions() {
        List<PermissionResponseDto> permissions = permissionService.findAll();
        return ResponseEntity.ok(new ApiResponse<>("Permissions retrieved successfully", permissions));
    }
}
