package com.example.umc8th.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;


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
}
