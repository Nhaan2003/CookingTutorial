package com.example.cookingtutorial.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Recipe> recipes;
}