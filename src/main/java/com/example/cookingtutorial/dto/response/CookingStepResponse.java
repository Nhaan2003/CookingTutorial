package com.example.cookingtutorial.dto.response;

import lombok.Data;

@Data
public class CookingStepResponse {
    private Integer stepNumber;
    private String instruction;
    private String imageURL;
    private String videoURL;
    private Integer estimatedTime;
    private String tips;
}
