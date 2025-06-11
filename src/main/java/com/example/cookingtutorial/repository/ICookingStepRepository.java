package com.example.cookingtutorial.repository;

import com.example.cookingtutorial.entity.CookingStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICookingStepRepository extends JpaRepository<CookingStep, Integer> {
}
