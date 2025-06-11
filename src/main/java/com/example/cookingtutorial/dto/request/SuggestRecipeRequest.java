package com.example.cookingtutorial.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class SuggestRecipeRequest {
    private List<String> availableIngredients;
}