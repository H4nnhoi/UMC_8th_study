package com.example.umc8th.repository.region;

import com.example.umc8th.web.dto.home.HomeDto;

public interface RegionRepositoryCustom {

    HomeDto findHomeDtoByMemberId(Long memberId);
}
