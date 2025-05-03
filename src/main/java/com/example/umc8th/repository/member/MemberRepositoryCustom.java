package com.example.umc8th.repository.member;

import com.example.umc8th.web.dto.member.ResponseMemberDto;

import java.util.Optional;

public interface MemberRepositoryCustom {

    Optional<ResponseMemberDto> findResponseMemberDtoById(Long memberId);
}
