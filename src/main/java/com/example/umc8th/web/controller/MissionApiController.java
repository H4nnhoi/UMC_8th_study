package com.example.umc8th.web.controller;


import com.example.umc8th.apiPayload.ApiResponse;
import com.example.umc8th.service.mission.MissionCommandService;
import com.example.umc8th.web.dto.mission.RequestMissionDto;
import com.example.umc8th.web.dto.region.RequestRestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionApiController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/restaurants/{restaurantId}")
    public ApiResponse<Long> addMissionOfRestaurant(@PathVariable Long restaurantId,
                                                    @RequestBody RequestMissionDto.AddDto missionDto) {
        return ApiResponse.onSuccess(missionCommandService.registerMission(restaurantId, missionDto));
    }

    @PostMapping("/{missionId}/members/{memberId}")
    public ApiResponse<Long> addMyMission(@PathVariable Long missionId,
                                          @PathVariable Long memberId) {
        return ApiResponse.onSuccess(missionCommandService.addMissionOfMember(memberId, missionId));
    }
}
