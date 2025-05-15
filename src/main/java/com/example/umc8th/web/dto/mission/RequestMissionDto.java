package com.example.umc8th.web.dto.mission;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


public class RequestMissionDto {
    @Data
    @Builder
    public static class RegisterDto{
        private String content;
        private LocalDate dueDate;
        private int point;
    }
}
