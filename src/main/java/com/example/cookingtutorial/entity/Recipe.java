package com.example.cookingtutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    private String title;
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer difficultyLevel;
    private Integer servingSize;
    private String thumbnailURL;
    private String videoURL;
    private Boolean isVerified;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer viewCount;
    private BigDecimal rating;


    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<CookingStep> steps;

    @OneToMany(mappedBy = "recipe")
    private List<Rating> ratings;

    @ManyToMany
    @JoinTable(
            name = "RecipeCategories",
            joinColumns = @JoinColumn(name = "recipeID"),
            inverseJoinColumns = @JoinColumn(name = "categoryID")
    )
    private List<Category> categories;
}