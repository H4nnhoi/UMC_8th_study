package com.example.umc8th.repository.RegionRepository;

import com.example.umc8th.web.dto.home.HomeDto;

import java.util.List;

public interface RegionRepositoryCustom {

    HomeDto findHomeDtoByMemberId(Long memberId);
}
