package com.example.umc8th.domain.mission;

import com.example.umc8th.domain.common.BaseEntity;
import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.member.Member;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MyMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_mission_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    private String identifiedNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
