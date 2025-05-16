package com.example.umc8th.web.dto.member;

import com.example.umc8th.domain.member.Gender;
import com.example.umc8th.domain.member.MemberStatus;
import com.example.umc8th.domain.member.Role;
import com.example.umc8th.domain.member.SocialType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


public class RequestMemberDto {

    @Data
    @Builder
    public static class JoinDto{
        @NotNull
        private String name;
        @NotNull
        private String nickname;
        @NotNull
        private String address;
        private String specAddress;
        @NotNull
        private Gender gender;
        @NotNull
        private SocialType socialType;
        @NotNull
        private MemberStatus status;
        @NotNull
        private String email;
    }

}
