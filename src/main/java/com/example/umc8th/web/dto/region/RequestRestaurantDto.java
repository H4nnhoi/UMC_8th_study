package com.example.umc8th.web.dto.region;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;


public class RequestRestaurantDto {

    @Data
    @Builder
    @Jacksonized
    public static class RegisterDto{
        private String name;
        private String imgUrl;
        private String address;
    }

}
