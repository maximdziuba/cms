package com.example.cms.service.impl;

import com.example.cms.security.dto.UserDto;
import com.example.cms.model.Role;
import com.example.cms.model.User;
import com.example.cms.repository.UserRepository;
import com.example.cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserDto user) {
        User userToSave = new User();
        userToSave.setEmail(user.getEmail());
        userToSave.setName("Default name");
        userToSave.setPassword(user.getPassword());
        userToSave.setRole(Role.ADMIN);
        return userRepository.save(userToSave);
    }

    @Override
    public User findUserByEmail(String email) {
        var user = userRepository.findUserByEmail(email);
        return user;
    }
}
