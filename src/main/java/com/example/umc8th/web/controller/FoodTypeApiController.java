package com.example.umc8th.web.controller;

import com.example.umc8th.service.food_type.FoodTypeCommandService;
import com.example.umc8th.web.dto.foodtype.RequestFoodTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food-types")
@RequiredArgsConstructor
public class FoodTypeApiController {

    private final FoodTypeCommandService foodTypeCommandService;

    @PostMapping
    public Long registerFoodType(@RequestBody RequestFoodTypeDto requestFoodTypeDto) {
        return foodTypeCommandService.registerFoodType(requestFoodTypeDto);
    }

    @PostMapping("/{foodTypeId}/members/{memberId}")
    public Long addPreferFoodTypeOfMember(@PathVariable Long foodTypeId,
                                          @PathVariable Long memberId) {
        return foodTypeCommandService.addFoodTypeOfMember(foodTypeId, memberId);
    }
}
