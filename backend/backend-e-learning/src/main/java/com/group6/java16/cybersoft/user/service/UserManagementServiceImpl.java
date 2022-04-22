package com.group6.java16.cybersoft.user.service;

import com.group6.java16.cybersoft.user.dto.UserCreateDTO;
import com.group6.java16.cybersoft.user.dto.UserResponseDTO;
import com.group6.java16.cybersoft.user.mapper.UserMapper;
import com.group6.java16.cybersoft.user.repository.ELUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService{
    
    @Autowired
    private ELUserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public UserResponseDTO createUser(UserCreateDTO user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return UserMapper.INSTANCE.toUserResponseDTO(userRepository.save(UserMapper.INSTANCE.toModel(user)));
    }
}
