package com.example.umc8th.repository.member;

import com.example.umc8th.web.dto.member.ResponseMemberDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.umc8th.domain.member.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<ResponseMemberDto> findResponseMemberDtoById(Long memberId) {
        ResponseMemberDto dto = jpaQueryFactory
                .select(Projections.constructor(ResponseMemberDto.class,
                        member.name,
                        member.nickname,
                        member.email,
                        member.point.coalesce(0)
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();

        return Optional.ofNullable(dto);
    }
}
