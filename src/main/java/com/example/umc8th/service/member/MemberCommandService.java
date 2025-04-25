package com.example.umc8th.service.member;

import com.example.umc8th.web.dto.member.RequestMemberDto;

public interface MemberCommandService {

    Long registerMember(RequestMemberDto dto);

    void removeMember(Long memberId);
}
