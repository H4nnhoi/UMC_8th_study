package com.example.umc8th.web.dto.member;

import com.example.umc8th.domain.member.Gender;
import com.example.umc8th.domain.member.MemberStatus;
import com.example.umc8th.domain.member.Role;
import com.example.umc8th.domain.member.SocialType;
import lombok.Builder;
import lombok.Data;


public class RequestMemberDto {

    @Data
    @Builder
    public static class JoinDto{
        private String name;
        private String nickname;
        private String address;
        private String specAddress;
        private Gender gender;
        private SocialType socialType;
        private MemberStatus status;
        private String email;
    }

}
