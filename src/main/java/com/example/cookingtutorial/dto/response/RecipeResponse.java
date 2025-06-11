package com.example.cookingtutorial.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecipeResponse {
    private Integer recipeID;
    private String title;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer difficultyLevel;
    private Integer servingSize;
    private String thumbnailURL;
    private String videoURL;
    private LocalDateTime createdAt;
    private BigDecimal rating;
    private Integer viewCount;

    private List<RecipeIngredientResponse> ingredients;
    private List<CookingStepResponse> steps;
}