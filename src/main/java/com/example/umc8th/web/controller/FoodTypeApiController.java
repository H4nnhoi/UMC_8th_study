package com.example.umc8th.web.controller;

import com.example.umc8th.domain.foodType.PreferFoodType;
import com.example.umc8th.service.food_type.FoodTypeCommandService;
import com.example.umc8th.service.food_type.FoodTypeQueryService;
import com.example.umc8th.web.dto.foodtype.RequestFoodTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-types")
@RequiredArgsConstructor
public class FoodTypeApiController {

    private final FoodTypeCommandService foodTypeCommandService;
    private final FoodTypeQueryService foodTypeQueryService;

    @PostMapping
    public Long registerFoodType(@RequestBody RequestFoodTypeDto requestFoodTypeDto) {
        return foodTypeCommandService.registerFoodType(requestFoodTypeDto);
    }

    @PostMapping("/{foodTypeId}/members/{memberId}")
    public Long addPreferFoodTypeOfMember(@PathVariable Long foodTypeId,
                                          @PathVariable Long memberId) {
        return foodTypeCommandService.addFoodTypeOfMember(foodTypeId, memberId);
    }

    @GetMapping("/members/{memberId}")
    public List<String> getPreferFoodType(@PathVariable Long memberId) {
        List<PreferFoodType> preferFoodTypeList = foodTypeQueryService.findPreferFoodTypeList(memberId);
        List<String> result = preferFoodTypeList.stream().map(preferFoodType -> preferFoodType.getFoodType().getName()).toList();
        return result;
    }
}
