package com.example.umc8th.web.dto.converter;

import com.example.umc8th.domain.restaurant.Restaurant;
import com.example.umc8th.web.dto.region.RequestRestaurantDto;

public class RestaurantConverter {

    public static Restaurant registerToRestaurantEntity(RequestRestaurantDto.RegisterDto dto) {
        return Restaurant.builder()
                .address(dto.getAddress())
                .name(dto.getName())
                .imgUrl(dto.getImgUrl())
                .build();
    }
}
