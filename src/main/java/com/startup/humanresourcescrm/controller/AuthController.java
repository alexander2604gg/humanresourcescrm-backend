package com.startup.humanresourcescrm.controller;

import com.startup.humanresourcescrm.dto.user.AuthLoginRequestDto;
import com.startup.humanresourcescrm.dto.user.AuthResponseDto;
import com.startup.humanresourcescrm.service.impl.UserDetailsServiceImpl;
import com.startup.humanresourcescrm.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDto>> login (@RequestBody AuthLoginRequestDto authLoginRequestDto){
        AuthResponseDto authResponseDto = userDetailsService.loginUser(authLoginRequestDto);
        return ResponseEntity.ok(new ApiResponse<>("Login successfully" , authResponseDto));
    }

}
