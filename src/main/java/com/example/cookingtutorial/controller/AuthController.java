package com.example.cookingtutorial.controller;

import com.example.cookingtutorial.dto.request.LoginRequest;
import com.example.cookingtutorial.dto.request.RegisterRequest;
import com.example.cookingtutorial.dto.response.UserResponse;
import com.example.cookingtutorial.entity.User;
import com.example.cookingtutorial.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User user = userService.register(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {
        User user = userService.login(request);
        return ResponseEntity.ok(new UserResponse(user));
    }
}