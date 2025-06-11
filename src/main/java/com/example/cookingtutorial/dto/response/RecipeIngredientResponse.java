package com.example.cookingtutorial.dto.response;

import lombok.Data;

@Data
public class RecipeIngredientResponse {
    private Integer ingredientID;
    private String ingredientName;
    private Double quantity;
    private String unit;
    private String notes;
    private String preparationMethod;
}