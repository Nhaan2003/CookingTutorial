package com.example.cookingtutorial.dto.request;

import lombok.Data;

@Data
public class CreateRecipeRequest {
    private String title;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer difficultyLevel;
    private Integer servingSize;
    private String thumbnailURL;
    private String videoURL;
    // Trong tương lai có thể thêm danh sách nguyên liệu và bước nấu
}