package com.example.umc8th.web.dto.mission;

import com.example.umc8th.annotation.ExistMyMission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.Map;


public class RequestMissionDto {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddDto{
        private String content;
        private LocalDate dueDate;
        private int point;
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionDto{
        @ExistMyMission
        private Map.Entry<Long, Long> memberAndMission;
    }
}
