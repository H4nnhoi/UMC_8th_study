package com.example.umc8th.service.mission;

import com.example.umc8th.web.dto.mission.RequestMissionDto;

public interface MissionCommandService {

    Long registerMission(Long restaurantId, RequestMissionDto.AddDto dto);

    Long addMissionOfMember(Long memberId, Long missionId);
}
