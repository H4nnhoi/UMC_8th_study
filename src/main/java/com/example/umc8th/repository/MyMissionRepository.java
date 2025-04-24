package com.example.umc8th.repository;

import com.example.umc8th.domain.mission.MyMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyMissionRepository extends JpaRepository<MyMission, Long> {
}
