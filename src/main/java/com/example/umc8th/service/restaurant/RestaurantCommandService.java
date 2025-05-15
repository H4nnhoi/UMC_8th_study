package com.example.umc8th.service.restaurant;

import com.example.umc8th.web.dto.region.RequestRestaurantDto;

public interface RestaurantCommandService {

    Long registerRestaurantInRegion(Long regionId, Long memberId, RequestRestaurantDto dto);
}
