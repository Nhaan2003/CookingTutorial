package com.example.cookingtutorial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RecipeIngredients")
@Getter
@Setter
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient {

    @Id
    @ManyToOne
    @JoinColumn(name = "recipeID")
    private Recipe recipe;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredientID")
    private Ingredient ingredient;

    private String quantity;
    private String unit;
    private String preparationMethod;
    private String notes;
}