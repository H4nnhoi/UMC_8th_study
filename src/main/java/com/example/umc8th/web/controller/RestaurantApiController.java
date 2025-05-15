package com.example.umc8th.web.controller;

import com.example.umc8th.apiPayload.ApiResponse;
import com.example.umc8th.domain.restaurant.Restaurant;
import com.example.umc8th.service.restaurant.RestaurantCommandService;
import com.example.umc8th.web.dto.region.RequestRestaurantDto;
import com.example.umc8th.web.dto.region.RequestRestaurantDto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantApiController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/regions/{regionId}/members/{memberId}")
    public ApiResponse<Long> registerRestaurant(@PathVariable Long regionId,
                                                @PathVariable Long memberId,
                                                @RequestBody RegisterDto dto) {
        Long restaurantId = restaurantCommandService.registerRestaurantInRegion(regionId, memberId, dto);
        return ApiResponse.onSuccess(restaurantId);
    }
}
