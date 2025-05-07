package com.startup.humanresourcescrm.controller;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.service.impl.UserServiceImpl;
import com.startup.humanresourcescrm.util.ApiResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
