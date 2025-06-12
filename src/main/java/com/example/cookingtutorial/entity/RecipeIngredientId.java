package com.example.cookingtutorial.entity;

import java.io.Serializable;
import java.util.Objects;

public class RecipeIngredientId implements Serializable {
    private Integer recipe;
    private Integer ingredient;

    public RecipeIngredientId() {}

    public RecipeIngredientId(Integer recipe, Integer ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientId that)) return false;
        return Objects.equals(recipe, that.recipe) && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe, ingredient);
    }
}
