package com.example.umc8th.repository.restaurant;

import com.example.umc8th.domain.restaurant.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {

    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}
