package com.example.umc8th.domain.member;

import com.example.umc8th.domain.common.BaseEntity;
import com.example.umc8th.domain.foodType.PreferFoodType;
import com.example.umc8th.domain.mission.Mission;
import com.example.umc8th.domain.mission.MyMission;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String nickname;

    private String address;

    private String specAddress;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MyMission> myMissionList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PreferFoodType> preferFoodTypeList = new ArrayList<>();
}
