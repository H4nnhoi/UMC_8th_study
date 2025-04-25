package com.example.umc8th.web.controller;

import com.example.umc8th.service.member.MemberCommandService;
import com.example.umc8th.web.dto.member.RequestMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberCommandService memberCommandService;

    @PostMapping
    public Long registerMember(@RequestBody RequestMemberDto requestMemberDto) {
        return memberCommandService.registerMember(requestMemberDto);
    }

    @DeleteMapping("/{memberId}")
    public void removeMember(@PathVariable Long memberId) {
        memberCommandService.removeMember(memberId);
    }


}
