package com.example.umc8th.repository;

import com.example.umc8th.domain.foodType.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
