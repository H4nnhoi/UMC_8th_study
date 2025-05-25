package com.example.umc8th.converter;

import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.member.Role;
import com.example.umc8th.web.dto.member.RequestMemberDto;

public class MemberConverter {

    public static Member joinToMemberEntity(RequestMemberDto.JoinDto dto) {
        return Member.builder()
                .point(0)
                .name(dto.getName())
                .gender(dto.getGender())
                .nickname(dto.getNickname())
                .role(Role.ROLE_USER)
                .address(dto.getAddress())
                .socialType(dto.getSocialType())
                .status(dto.getStatus())
                .email(dto.getEmail())
                .build();
    }
}
