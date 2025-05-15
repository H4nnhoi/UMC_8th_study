package com.example.umc8th.service.member;

import com.example.umc8th.web.dto.member.RequestMemberDto;
import com.example.umc8th.web.dto.member.RequestMemberDto.JoinDto;

public interface MemberCommandService {

    Long registerMember(JoinDto dto);

    void removeMember(Long memberId);
}
