package com.example.umc8th.web.dto.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMemberDto {
    private String name;
    private String nickname;
    private String email;
    private int point;
}
