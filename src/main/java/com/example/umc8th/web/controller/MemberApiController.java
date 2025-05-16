package com.example.umc8th.web.controller;

import com.example.umc8th.apiPayload.ApiResponse;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.repository.member.MemberRepository;
import com.example.umc8th.service.member.MemberCommandService;
import com.example.umc8th.web.dto.member.RequestMemberDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberCommandService memberCommandService;
    private final MemberRepository memberRepository;

    @PostMapping
    public ApiResponse<Long> registerMember(@RequestBody @Valid RequestMemberDto.JoinDto requestMemberDto) {
        return ApiResponse.onSuccess(memberCommandService.registerMember(requestMemberDto));
    }

    @DeleteMapping("/{memberId}")
    public void removeMemberWithAllRelations(@PathVariable Long memberId) {
        memberCommandService.removeMember(memberId);
    }

    @GetMapping
    public List<String> allMemberUsername() {
        List<Member> all = memberRepository.findAll();
        return all.stream().map(member -> member.getName())
                .toList();
    }


}
