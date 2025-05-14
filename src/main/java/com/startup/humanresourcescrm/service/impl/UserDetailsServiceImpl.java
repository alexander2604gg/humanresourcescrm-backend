package com.startup.humanresourcescrm.service.impl;

import com.startup.humanresourcescrm.dto.user.AuthLoginRequestDto;
import com.startup.humanresourcescrm.dto.user.AuthResponseDto;
import com.startup.humanresourcescrm.entity.UserSec;
import com.startup.humanresourcescrm.repository.UserRepository;
import com.startup.humanresourcescrm.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserSec userSec = userRepository.findUserSecByEmail(email)
                .orElseThrow( () ->new UsernameNotFoundException(email + " was not found"));

        Set<GrantedAuthority> authorityList = new HashSet<>();

        userSec.getRoles()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().getName()))));

        userSec.getRoles().stream()
                .flatMap(role-> role.getRole().getPermissions().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getPermission().getName())));

        return new User(userSec.getEmail() , userSec.getPassword() , userSec.isEnabled() ,true,
                true, true , authorityList);
    }

    public AuthResponseDto loginUser (AuthLoginRequestDto authLoginRequestDto){
        Authentication  authentication = authenticate(authLoginRequestDto.getEmail() , authLoginRequestDto.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtil.createToken(authentication);
        return new AuthResponseDto(authLoginRequestDto.getEmail(), accessToken);
    }

    public Authentication authenticate(String email, String password) {
        UserDetails userDetails = loadUserByUsername(email);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }
        return new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );
    }




}
