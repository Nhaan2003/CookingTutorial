package com.example.cookingtutorial.repository;

import com.example.cookingtutorial.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
    // Lấy tất cả công thức đã xác thực, mới nhất
    List<Recipe> findByIsVerifiedTrueOrderByCreatedAtDesc();

    // Tìm kiếm theo tiêu đề hoặc nguyên liệu
    List<Recipe> findByTitleContainingIgnoreCaseOrIngredients_Ingredient_IngredientNameContainingIgnoreCase(String title, String ingredientName);

    // Gợi ý công thức từ nguyên liệu có sẵn
    List<Recipe> findByIngredients_Ingredient_IngredientNameIn(List<String> ingredientNames);

    // Lọc theo category và difficulty
    List<Recipe> findByCategoryAndDifficulty(String category, Integer difficulty);

}