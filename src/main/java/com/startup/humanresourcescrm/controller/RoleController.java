package com.startup.humanresourcescrm.controller;

import com.startup.humanresourcescrm.dto.role.RoleCreateDto;
import com.startup.humanresourcescrm.dto.role.RoleResponseDto;
import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.service.RoleService;
import com.startup.humanresourcescrm.service.impl.RoleServiceImpl;
import com.startup.humanresourcescrm.service.impl.UserServiceImpl;
import com.startup.humanresourcescrm.util.ApiResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
public class RoleController {

    private final RoleServiceImpl roleService;

    @PostMapping
    public ResponseEntity<ApiResponse<RoleResponseDto>> createRole(RoleCreateDto roleCreateDto) {
        RoleResponseDto roleResponseDto = roleService.save(roleCreateDto);
        return ResponseEntity.ok(new ApiResponse<>("Role created successfully", roleResponseDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RoleResponseDto>>> getAllRoles() {
        List<RoleResponseDto> roles = roleService.findAll();
        return ResponseEntity.ok(new ApiResponse<>("Roles retrieved successfully", roles));
    }
}
