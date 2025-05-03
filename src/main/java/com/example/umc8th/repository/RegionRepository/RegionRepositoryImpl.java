package com.example.umc8th.repository.RegionRepository;

import com.example.umc8th.domain.region.MyRegion;
import com.example.umc8th.domain.region.Region;
import com.example.umc8th.domain.region.RegionStatus;
import com.example.umc8th.web.dto.home.HomeDto;
import com.example.umc8th.web.dto.mission.ResponseMissionDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.umc8th.domain.member.QMember.member;
import static com.example.umc8th.domain.mission.QMission.mission;
import static com.example.umc8th.domain.mission.QMyMission.myMission;
import static com.example.umc8th.domain.region.QMyRegion.myRegion;
import static com.example.umc8th.domain.region.QRegion.region1;
import static com.example.umc8th.domain.restaurant.QRestaurant.restaurant;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public HomeDto findHomeDtoByMemberId(Long memberId) {
        // 1. ACTIVE 상태의 MyRegion 조회
        Region activeRegion = jpaQueryFactory
                .select(region1)
                .from(myRegion)
                .join(myRegion.region, region1)
                .where(
                        myRegion.member.id.eq(memberId),
                        myRegion.regionStatus.eq(RegionStatus.ACTIVE)
                )
                .fetchFirst();

        if (activeRegion == null) {
            throw new IllegalStateException("활성화된 지역이 없습니다.");
        }

        // 2. member의 point 조회
        Integer point = jpaQueryFactory
                .select(member.point)
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
        if (point == null) point = 0;

        // 3. 아직 참여하지 않은 mission 조회
        List<ResponseMissionDto> responseMissionDtoList = jpaQueryFactory
                .select(Projections.constructor(ResponseMissionDto.class,
                        mission.id,
                        mission.content,
                        mission.point
                ))
                .from(mission)
                .join(mission.restaurant, restaurant)
                .where(
                        restaurant.region.eq(activeRegion),
                        mission.notIn(
                                JPAExpressions
                                        .select(myMission.mission)
                                        .from(myMission)
                                        .where(myMission.member.id.eq(memberId))
                        )
                )
                .fetch();

        return HomeDto.builder()
                .region(activeRegion.getRegion()) // region 이름 (String)
                .point(point)
                .responseMissionDtoList(responseMissionDtoList)
                .build();
    }
}
