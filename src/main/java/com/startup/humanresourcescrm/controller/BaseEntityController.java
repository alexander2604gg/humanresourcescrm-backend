package com.startup.humanresourcescrm.controller;

import com.startup.humanresourcescrm.dto.entity.EntityCompanyCreateDto;
import com.startup.humanresourcescrm.dto.entity.EntityPersonCreateDto;
import com.startup.humanresourcescrm.dto.user.AuthLoginRequestDto;
import com.startup.humanresourcescrm.dto.user.AuthResponseDto;
import com.startup.humanresourcescrm.service.BaseEntityService;
import com.startup.humanresourcescrm.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entity")
@AllArgsConstructor
public class BaseEntityController {

    private final BaseEntityService baseEntityService;

    @PostMapping("/company")
    public ResponseEntity<ApiResponse<Void>> saveEntity (@RequestBody EntityCompanyCreateDto entityCompanyCreateDto){
        baseEntityService.saveEntityCompany(entityCompanyCreateDto);
        return ResponseEntity.ok(new ApiResponse<>("Company created successfully"));
    }

    @PostMapping("/person")
    public ResponseEntity<ApiResponse<Void>> savePerson (@RequestBody EntityPersonCreateDto entityPersonCreateDto){
        baseEntityService.saveEntityPersona(entityPersonCreateDto);
        return ResponseEntity.ok(new ApiResponse<>("Person created successfully"));
    }

}
