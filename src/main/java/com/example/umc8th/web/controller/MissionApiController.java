package com.example.umc8th.web.controller;


import com.example.umc8th.apiPayload.ApiResponse;
import com.example.umc8th.web.dto.mission.RequestMissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionApiController {

    @PostMapping("/restaurants/{restaurantId}")
    public ApiResponse<Long> addMissionOfRestaurant(@PathVariable Long restaurantId,
                                                    @RequestBody RequestMissionDto.RegisterDto dto) {

    }
}
