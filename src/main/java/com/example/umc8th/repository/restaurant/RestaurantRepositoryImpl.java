package com.example.umc8th.repository.restaurant;

import com.example.umc8th.domain.restaurant.QRestaurant;
import com.example.umc8th.domain.restaurant.Restaurant;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.umc8th.domain.restaurant.QRestaurant.restaurant;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(restaurant.name.eq(name));
        }

        if (score != null) {
            predicate.and(restaurant.score.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(predicate)
                .fetch();
    }
}
