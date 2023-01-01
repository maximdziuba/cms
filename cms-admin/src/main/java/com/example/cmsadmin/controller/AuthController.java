package com.example.cmsadmin.controller;

import com.example.cmsadmin.dto.JwtRequest;
import com.example.cmsadmin.dto.JwtResponse;
import com.example.cmsadmin.security.JwtUtil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;


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
}