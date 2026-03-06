package com.expenso.controller;

import com.expenso.dto.LoginRequest;
import com.expenso.dto.UserRegistrationDTO;
import com.expenso.dto.UserResponseDTO;
import com.expenso.model.User;
import com.expenso.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDTO dto) {
        try {
            User user = User.builder()
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .build();
            User saved = userService.registerUser(user);
            UserResponseDTO resp = UserResponseDTO.builder()
                    .id(saved.getId())
                    .name(saved.getName())
                    .email(saved.getEmail())
                    .createdAt(saved.getCreatedAt())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        return userService.loginUser(req.getEmail(), req.getPassword())
                .map(user -> ResponseEntity.ok(UserResponseDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .createdAt(user.getCreatedAt())
                        .build()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"));
    }
}
