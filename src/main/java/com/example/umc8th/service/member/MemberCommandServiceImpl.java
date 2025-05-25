package com.example.umc8th.service.member;

import com.example.umc8th.domain.member.Member;
import com.example.umc8th.repository.member.MemberRepository;
import com.example.umc8th.repository.mission.MyMissionRepository;
import com.example.umc8th.repository.foodtype.PreferFoodTypeRepository;
import com.example.umc8th.converter.MemberConverter;
import com.example.umc8th.web.dto.member.RequestMemberDto.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final PreferFoodTypeRepository preferFoodTypeRepository;
    private final MyMissionRepository myMissionRepository;

    @Override
    public Long registerMember(JoinDto dto) {
        Member member = MemberConverter.joinToMemberEntity(dto);
        return memberRepository.save(member).getId();
    }

    @Override
    public void removeMember(Long memberId) {
        myMissionRepository.deleteAllByMemberId(memberId);
        preferFoodTypeRepository.deleteAllByMemberId(memberId);
        memberRepository.deleteById(memberId);
    }
}
