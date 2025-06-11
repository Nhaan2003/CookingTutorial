package com.example.cookingtutorial.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserRequest {
    private String fullName;
    private String email;
    private String password;
}
