package com.example.umc8th.web.controller;


import com.example.umc8th.apiPayload.ApiResponse;
import com.example.umc8th.service.mission.MissionCommandService;
import com.example.umc8th.web.dto.mission.RequestMissionDto;
import com.example.umc8th.web.dto.region.RequestRestaurantDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionApiController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/restaurants/{restaurantId}")
    public ApiResponse<Long> addMissionOfRestaurant(@PathVariable Long restaurantId,
                                                    @RequestBody @Valid RequestMissionDto.AddDto missionDto) {
        return ApiResponse.onSuccess(missionCommandService.registerMission(restaurantId, missionDto));
    }

    @PostMapping
    public ApiResponse<Long> addMyMission(@RequestBody @Valid RequestMissionDto.MyMissionDto dto) {
        return ApiResponse.onSuccess(missionCommandService
                .addMissionOfMember(dto.getMemberAndMission().getKey(), dto.getMemberAndMission().getValue()));
    }

}
