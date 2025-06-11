package com.example.cookingtutorial.controller;

import com.example.cookingtutorial.dto.request.CreateRecipeRequest;
import com.example.cookingtutorial.dto.request.SuggestRecipeRequest;
import com.example.cookingtutorial.dto.response.RecipeResponse;
import com.example.cookingtutorial.service.recipe.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private IRecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeResponse>> getAllVerifiedRecipes() {
        return ResponseEntity.ok(recipeService.getAllVerifiedRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecipeResponse>> searchRecipes(@RequestParam String q) {
        return ResponseEntity.ok(recipeService.searchRecipes(q));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<RecipeResponse>> filterRecipes(@RequestParam(required = false) String category,
                                                              @RequestParam(required = false) Integer difficulty) {
        return ResponseEntity.ok(recipeService.filterRecipes(category, difficulty));
    }

    @PostMapping("/suggest")
    public ResponseEntity<List<RecipeResponse>> suggestRecipes(@RequestBody SuggestRecipeRequest request) {
        return ResponseEntity.ok(recipeService.suggestRecipes(request));
    }

    @PostMapping
    public ResponseEntity<RecipeResponse> createRecipe(@RequestBody CreateRecipeRequest request) {
        return ResponseEntity.ok(recipeService.createRecipe(request));
    }
}
