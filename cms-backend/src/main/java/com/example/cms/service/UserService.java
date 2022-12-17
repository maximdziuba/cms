package com.example.cms.service;

import com.example.cms.security.dto.UserDto;
import com.example.cms.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User saveUser(UserDto user);

    User findUserByEmail(String email);
}
