package com.example.cookingtutorial.service.recipe;

import com.example.cookingtutorial.dto.response.*;
import com.example.cookingtutorial.dto.request.*;
import com.example.cookingtutorial.entity.*;
import com.example.cookingtutorial.repository.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {

    @Autowired
    private IRecipeRepository recipeRepository;

    @Override
    public List<RecipeResponse> getAllVerifiedRecipes() {
        List<Recipe> recipes = recipeRepository.findByIsVerifiedTrueOrderByCreatedAtDesc();
        return recipes.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public RecipeResponse getRecipeById(Integer id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        return convertToResponse(recipe);
    }

    @Override
    public List<RecipeResponse> searchRecipes(String keyword) {
        List<Recipe> recipes = recipeRepository.findByTitleContainingIgnoreCaseOrIngredients_Ingredient_IngredientNameContainingIgnoreCase(keyword, keyword);
        return recipes.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public List<RecipeResponse> filterRecipes(String category, Integer difficulty) {
        List<Recipe> recipes;

        if (difficulty != null) {
            recipes = recipeRepository.findByDifficultyLevelAndIsVerifiedTrueOrderByCreatedAtDesc(difficulty);
        } else {
            recipes = recipeRepository.findByIsVerifiedTrueOrderByCreatedAtDesc();
        }

        return recipes.stream().map(this::convertToResponse).collect(Collectors.toList());
    }


    @Override
    public List<RecipeResponse> suggestRecipes(SuggestRecipeRequest request) {
        List<Recipe> recipes = recipeRepository.findByIngredients_Ingredient_IngredientNameIn(request.getAvailableIngredients());
        return recipes.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public RecipeResponse createRecipe(CreateRecipeRequest request) {
        Recipe recipe = new Recipe();
        recipe.setTitle(request.getTitle());
        recipe.setDescription(request.getDescription());
        recipe.setPrepTime(request.getPrepTime());
        recipe.setCookTime(request.getCookTime());
        recipe.setDifficultyLevel(request.getDifficultyLevel());
        recipe.setServingSize(request.getServingSize());
        recipe.setThumbnailURL(request.getThumbnailURL());
        recipe.setVideoURL(request.getVideoURL());
        recipe.setIsVerified(false);
        recipe.setCreatedAt(java.time.LocalDateTime.now());
        recipe.setViewCount(0);
        recipe.setRating(java.math.BigDecimal.ZERO);
        return convertToResponse(recipeRepository.save(recipe));
    }

    private RecipeResponse convertToResponse(Recipe recipe) {
        RecipeResponse dto = new RecipeResponse();
        dto.setRecipeID(recipe.getRecipeID());
        dto.setTitle(recipe.getTitle());
        dto.setDescription(recipe.getDescription());
        dto.setPrepTime(recipe.getPrepTime());
        dto.setCookTime(recipe.getCookTime());
        dto.setDifficultyLevel(recipe.getDifficultyLevel());
        dto.setServingSize(recipe.getServingSize());
        dto.setThumbnailURL(recipe.getThumbnailURL());
        dto.setVideoURL(recipe.getVideoURL());
        dto.setCreatedAt(recipe.getCreatedAt());
        dto.setRating(recipe.getRating());
        dto.setViewCount(recipe.getViewCount());

        if (recipe.getIngredients() != null) {
            List<RecipeIngredientResponse> ingredientResponses = recipe.getIngredients().stream().map(i -> {
                RecipeIngredientResponse ir = new RecipeIngredientResponse();
                ir.setIngredientID(i.getIngredient().getIngredientID());
                ir.setIngredientName(i.getIngredient().getIngredientName());
                ir.setQuantity(i.getQuantity());
                ir.setUnit(i.getUnit());
                ir.setNotes(i.getNotes());
                ir.setPreparationMethod(i.getPreparationMethod());
                return ir;
            }).collect(Collectors.toList());
            dto.setIngredients(ingredientResponses);
        }

        if (recipe.getSteps() != null) {
            List<CookingStepResponse> stepResponses = recipe.getSteps().stream().map(s -> {
                CookingStepResponse step = new CookingStepResponse();
                step.setStepNumber(s.getStepNumber());
                step.setInstruction(s.getInstruction());
                step.setImageURL(s.getImageURL());
                step.setVideoURL(s.getVideoURL());
                step.setEstimatedTime(s.getEstimatedTime());
                step.setTips(s.getTips());
                return step;
            }).collect(Collectors.toList());
            dto.setSteps(stepResponses);
        }

        return dto;
    }
}