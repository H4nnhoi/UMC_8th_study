package com.example.umc8th.service.food_type;

import com.example.umc8th.domain.foodType.PreferFoodType;

import java.util.List;

public interface FoodTypeQueryService {
    List<PreferFoodType> findPreferFoodTypeList(Long memberId);
}
