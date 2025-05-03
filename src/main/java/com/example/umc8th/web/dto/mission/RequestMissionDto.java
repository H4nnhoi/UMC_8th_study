package com.example.umc8th.web.dto.mission;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RequestMissionDto {

    private String content;
    private LocalDate dueDate;
    private int point;
}
