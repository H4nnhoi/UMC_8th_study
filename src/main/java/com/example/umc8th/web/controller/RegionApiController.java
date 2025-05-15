package com.example.umc8th.web.controller;

import com.example.umc8th.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
public class RegionApiController {

    @PostMapping("/{regionId}/restaurants/{restaurantId}")
    public ApiResponse<Long> addRestaurantInRegion(@PathVariable Long regionId,
                                                   @PathVariable Long restaurantId) {

    }
}
