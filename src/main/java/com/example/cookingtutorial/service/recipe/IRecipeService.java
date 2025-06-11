// IRecipeService.java
package com.example.cookingtutorial.service.recipe;

import com.example.cookingtutorial.dto.response.RecipeResponse;
import com.example.cookingtutorial.dto.request.SuggestRecipeRequest;
import com.example.cookingtutorial.dto.request.CreateRecipeRequest;

import java.util.List;

public interface IRecipeService {
    List<RecipeResponse> getAllVerifiedRecipes();
    RecipeResponse getRecipeById(Integer id);
    List<RecipeResponse> searchRecipes(String keyword);
    List<RecipeResponse> filterRecipes(String category, Integer difficulty);
    List<RecipeResponse> suggestRecipes(SuggestRecipeRequest request);
    RecipeResponse createRecipe(CreateRecipeRequest request);
}