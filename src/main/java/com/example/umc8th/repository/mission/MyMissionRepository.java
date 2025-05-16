package com.example.umc8th.repository.mission;

import com.example.umc8th.domain.mission.MyMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyMissionRepository extends JpaRepository<MyMission, Long> {

    @Modifying
    @Query("DELETE FROM MyMission m WHERE m.member.id = :memberId")
    void deleteAllByMemberId(@Param("memberId") Long memberId);

    boolean existsByMemberIdAndMissionId(Long key, Long value);
}
