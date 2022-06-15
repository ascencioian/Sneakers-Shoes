package com.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.model.User;
import com.project.sec.UserRegistrationDto;

public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
}