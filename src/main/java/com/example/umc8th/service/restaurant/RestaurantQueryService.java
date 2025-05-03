package com.example.umc8th.service.restaurant;

import com.example.umc8th.domain.restaurant.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> findRestaurant(Long id);
    List<Restaurant> findRestaurantsByNameAndScore(String name, Float score);
}
