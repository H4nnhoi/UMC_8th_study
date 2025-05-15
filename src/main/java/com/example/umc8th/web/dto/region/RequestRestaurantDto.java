package com.example.umc8th.web.dto.region;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class RequestRestaurantDto {

    private String name;
    private String imgUrl;
    private String address;
}
