package com.example.umc8th.web.dto.mission;

import com.example.umc8th.annotation.ExistMyMission;
import jakarta.validation.constraints.NotNull;
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
        @NotNull
        private String content;
        @NotNull
        private LocalDate dueDate;
        @NotNull
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
