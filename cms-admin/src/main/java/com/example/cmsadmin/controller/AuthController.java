package com.example.cmsadmin.controller;

import com.example.cmsadmin.dto.JwtRequest;
import com.example.cmsadmin.dto.JwtResponse;
import com.example.cmsadmin.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;


    @GetMapping("/whoami")
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

//    @PostMapping("/registration")
//    ResponseEntity saveUser(@RequestBody UserDto userDto) throws Exception {
//        if (userService.findUserByEmail(userDto.getEmail()) != null) {
//            throw new Exception("This user already exists");
//        }
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        return ResponseEntity.ok(userService.saveUser(userDto));
//    }

}