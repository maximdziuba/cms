package com.example.cms.controller;

import com.example.cms.security.JwtUtil;
import com.example.cms.security.dto.JwtRequest;
import com.example.cms.security.dto.JwtResponse;
import com.example.cms.security.dto.UserDto;
import com.example.cms.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserDetailsService userDetailsService;

    @GetMapping
    @Operation(summary = "Get all users")
    @SecurityRequirement(name = "Bearer Authentication")
    List<com.example.cms.model.User> allUsers() {
        var users = userService.findAllUsers();
        return users;
    }

    @GetMapping("/whoami")
    @SecurityRequirement(name = "Bearer Authentication")
    String whoAmI(Authentication authentication) {
        return authentication.getName();
    }

    @PostMapping("/auth")
    JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
        final String token = jwtUtil.generateToken(userDetails);
        return new JwtResponse(token);
    }

    @PostMapping("/registration")
    ResponseEntity saveUser(@RequestBody UserDto userDto) throws Exception {
        if (userService.findUserByEmail(userDto.getEmail()) != null) {
            throw new Exception("This user already exists");
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

}

