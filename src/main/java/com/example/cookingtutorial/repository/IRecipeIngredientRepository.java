package com.example.cookingtutorial.repository;

import com.example.cookingtutorial.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {
}
