package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.user.UserCreateDto;
import com.startup.humanresourcescrm.dto.user.UserResponseDto;
import com.startup.humanresourcescrm.entity.UserSec;
import com.startup.humanresourcescrm.mapper.UserMapper;
import com.startup.humanresourcescrm.repository.UserRepository;
import com.startup.humanresourcescrm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto save(UserCreateDto userCreateDto) {
        userCreateDto.setPassword(encryptPassword(userCreateDto.getPassword()));
        UserSec userSaved = userRepository.save(userMapper.toEntityFromCreate(userCreateDto));
        return userMapper.toUserLoggedDto(userSaved);
    }

    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }


}
