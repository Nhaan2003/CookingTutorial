package com.example.cookingtutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "recipeID")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredientID")
    private Ingredient ingredient;

    private String quantity;
    private String unit;
    private String notes;
    private String preparationMethod;
}