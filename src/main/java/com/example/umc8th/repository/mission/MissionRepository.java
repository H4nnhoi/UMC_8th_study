package com.example.umc8th.repository.mission;

import com.example.umc8th.domain.mission.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
