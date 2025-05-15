package com.example.umc8th.service.restaurant;

import com.example.umc8th.web.dto.region.RequestRestaurantDto;
import com.example.umc8th.web.dto.region.RequestRestaurantDto.RegisterDto;

public interface RestaurantCommandService {

    Long registerRestaurantInRegion(Long regionId, Long memberId, RegisterDto dto);
}
