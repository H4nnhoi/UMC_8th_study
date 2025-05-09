package com.example.umc8th.web.dto.mission;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMissionDto {
    private Long missionId;
    private String content;
    private int point;
}
