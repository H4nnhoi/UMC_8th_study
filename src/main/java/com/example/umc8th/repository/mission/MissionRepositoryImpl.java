package com.example.umc8th.repository.mission;

import com.example.umc8th.domain.mission.Mission;
import com.example.umc8th.domain.mission.MissionStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.umc8th.domain.mission.QMission.mission;
import static com.example.umc8th.domain.mission.QMyMission.myMission;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Mission> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable) {
        // 메인 쿼리
        List<Mission> content = jpaQueryFactory
                .select(mission)
                .from(myMission)
                .join(myMission.mission, mission)
                .where(
                        myMission.member.id.eq(memberId),
                        status != null ? myMission.missionStatus.eq(status) : null
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 카운트 쿼리
        Long count = jpaQueryFactory
                .select(myMission.count())
                .from(myMission)
                .where(
                        myMission.member.id.eq(memberId),
                        status != null ? myMission.missionStatus.eq(status) : null
                )
                .fetchOne();

        return new PageImpl<>(content, pageable, count == null ? 0 : count);
    }
}
