package com.example.umc8th.repository.mission;

import com.example.umc8th.domain.mission.Mission;
import com.example.umc8th.domain.mission.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MissionRepositoryCustom {
    Page<Mission> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
}
