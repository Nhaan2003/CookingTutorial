package com.example.cookingtutorial.dto.response;

import com.example.cookingtutorial.entity.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private Integer userID;
    private String username;
    private String email;
    private String fullName;
    private String role;

    public UserResponse(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.fullName = user.getFullName();
        this.role = user.getRole();
    }
}
