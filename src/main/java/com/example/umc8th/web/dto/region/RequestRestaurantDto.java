package com.example.umc8th.web.dto.region;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;


public class RequestRestaurantDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterDto{
        @NotNull
        private String name;
        private String imgUrl;
        @NotNull
        private String address;
    }

}
