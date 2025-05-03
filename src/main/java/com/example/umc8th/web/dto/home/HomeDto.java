package com.example.umc8th.web.dto.home;

import com.example.umc8th.web.dto.mission.ResponseMissionDto;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class HomeDto {
    private String region;
    private int point;
    private int countRegionPassMission;
    @Builder.Default
    private List<ResponseMissionDto> responseMissionDtoList = new ArrayList<>();
}
