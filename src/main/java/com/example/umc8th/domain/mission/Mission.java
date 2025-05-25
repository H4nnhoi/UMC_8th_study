package com.example.umc8th.domain.mission;

import com.example.umc8th.domain.common.BaseEntity;
import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    private String content;

    private LocalDate dueDate;

    private int point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public void addMissionInRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
