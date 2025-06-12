package com.example.cookingtutorial.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "Ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredientID;

    private String ingredientName;

    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeIngredients;
}