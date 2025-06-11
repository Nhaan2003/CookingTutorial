package com.example.cookingtutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingID;

    private Integer score;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "recipeID")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
}