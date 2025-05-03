package com.example.umc8th.service.food_type;

import com.example.umc8th.web.dto.foodtype.RequestFoodTypeDto;

public interface FoodTypeCommandService {

    Long registerFoodType(RequestFoodTypeDto dto);

    Long addFoodTypeOfMember(Long foodTypeId, Long memberId);
}
