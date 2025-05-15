package com.example.umc8th.web.controller;

import com.example.umc8th.apiPayload.ApiResponse;
import com.example.umc8th.service.region.RegionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
public class RegionApiController {

    private final RegionCommandService regionCommandService;

    @PostMapping
    public ApiResponse<Long> registerRegion(@RequestParam String region) {
        return ApiResponse.onSuccess(regionCommandService.registerRegion(region));
    }
}
