package com.example.cookingtutorial.service.user;

import com.example.cookingtutorial.dto.request.LoginRequest;
import com.example.cookingtutorial.dto.request.RegisterRequest;
import com.example.cookingtutorial.dto.request.UpdateUserRequest;
import com.example.cookingtutorial.dto.response.UserResponse;
import com.example.cookingtutorial.entity.User;

public interface IUserService {
    User register(RegisterRequest request);
    User login(LoginRequest request);
    UserResponse getById(Integer id);
    UserResponse updateUser(Integer id, UpdateUserRequest request);
}

