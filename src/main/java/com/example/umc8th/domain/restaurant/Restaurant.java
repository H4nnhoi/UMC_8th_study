package com.example.umc8th.domain.restaurant;

import com.example.umc8th.domain.common.BaseEntity;
import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.region.Region;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    private String name;

    private String imgUrl;

    private String address;

    @Builder.Default
    private Float score = 0.0f;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_owner_id")
    private Member storeOwner;

    public void registerRegionAndOwner(Region region, Member member) {
        this.region = region;
        this.storeOwner = member;
    }


}
