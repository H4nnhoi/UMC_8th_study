package com.example.umc8th.domain.restaurant;

import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.region.Region;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    private String name;

    private String imgUrl;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_type_id")
    private FoodType foodType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;


}
