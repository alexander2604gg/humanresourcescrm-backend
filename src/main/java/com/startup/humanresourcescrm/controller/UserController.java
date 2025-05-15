package com.startup.humanresourcescrm.controller;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
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
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.save(userCreateDto);
        return ResponseEntity.ok(new ApiResponse<>("User created successfully", userResponseDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllUsers() {
        List<UserResponseDto> users = userService.findAll();
        return ResponseEntity.ok(new ApiResponse<>("Users retrieved successfully", users));
    }
}
