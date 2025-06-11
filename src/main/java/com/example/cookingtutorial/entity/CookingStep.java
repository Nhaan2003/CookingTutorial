package com.example.cookingtutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CookingStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stepID;

    @ManyToOne
    @JoinColumn(name = "recipeID")
    private Recipe recipe;

    private Integer stepNumber;
    private String instruction;
    private String imageURL;
    private String videoURL;
    private Integer estimatedTime;
    private String tips;
}