package com.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.entity.User;
import com.project.security.UserRegistrationDto;

public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
}