package com.example.cookingtutorial.repository;

import com.example.cookingtutorial.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {
}
