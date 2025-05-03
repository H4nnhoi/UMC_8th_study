package com.example.umc8th.service.member;

import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.member.MemberStatus;
import com.example.umc8th.domain.member.Role;
import com.example.umc8th.repository.MemberRepository;
import com.example.umc8th.repository.mission.MyMissionRepository;
import com.example.umc8th.repository.foodtype.PreferFoodTypeRepository;
import com.example.umc8th.web.dto.member.RequestMemberDto;
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
    public Long registerMember(RequestMemberDto dto) {
        Member member = Member.builder()
                .socialType(dto.getSocialType())
                .point(0)
                .gender(dto.getGender())
                .name(dto.getName())
                .role(Role.ROLE_USER)
                .status(MemberStatus.ACTIVE)
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .address(dto.getAddress())
                .build();
        return memberRepository.save(member).getId();
    }

    @Override
    public void removeMember(Long memberId) {
        myMissionRepository.deleteAllByMemberId(memberId);
        preferFoodTypeRepository.deleteAllByMemberId(memberId);
        memberRepository.deleteById(memberId);
    }
}
