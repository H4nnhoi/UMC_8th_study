package com.example.umc8th.web.converter;

import com.example.umc8th.domain.mission.Mission;
import com.example.umc8th.web.dto.mission.RequestMissionDto;

public class MissionConverter {

    public static Mission registerToMissionEntity(RequestMissionDto.AddDto dto) {
        return Mission.builder()
                .point(dto.getPoint())
                .content(dto.getContent())
                .dueDate(dto.getDueDate())
                .build();
    }
}
