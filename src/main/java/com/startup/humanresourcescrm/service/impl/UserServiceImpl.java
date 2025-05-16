package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.entity.UserSec;
import com.startup.humanresourcescrm.mapper.UserMapper;
import com.startup.humanresourcescrm.repository.UserRepository;
import com.startup.humanresourcescrm.service.UserRoleService;
import com.startup.humanresourcescrm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRoleService userRoleService;

    @Override
    public UserResponseDto save(UserCreateDto userCreateDto) {
        userCreateDto.setPassword(encryptPassword(userCreateDto.getPassword()));
        UserSec userSaved = userRepository.save(userMapper.toEntityFromCreate(userCreateDto));
        if (userCreateDto.getRoleIds() != null && !userCreateDto.getRoleIds().isEmpty()) {
            userRoleService.assignRolesToUser(userSaved, userCreateDto.getRoleIds());
        }
        return userMapper.toUserLoggedDto(userSaved);
    }

    public List<UserResponseDto> findAll() {
        List<UserSec> users = userRepository.findAll();
        return userMapper.toUserSecResponseDtoList(users);
    }

    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }


}
