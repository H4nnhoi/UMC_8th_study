package com.example.umc8th.service.mission;

import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.mission.Mission;
import com.example.umc8th.domain.mission.MissionStatus;
import com.example.umc8th.domain.mission.MyMission;
import com.example.umc8th.domain.restaurant.Restaurant;
import com.example.umc8th.repository.MemberRepository;
import com.example.umc8th.repository.mission.MissionRepository;
import com.example.umc8th.repository.mission.MyMissionRepository;
import com.example.umc8th.repository.restaurant.RestaurantRepository;
import com.example.umc8th.web.dto.mission.RequestMissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MyMissionRepository myMissionRepository;

    @Override
    public Long registerMission(Long restaurantId, RequestMissionDto dto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("not found restaurant"));
        Mission mission = Mission.builder()
                .point(dto.getPoint())
                .content(dto.getContent())
                .dueDate(dto.getDueDate())
                .restaurant(restaurant)
                .build();

        return missionRepository.save(mission).getId();
    }

    @Override
    public Long addMissionOfMember(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found member"));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("not found mission"));
        MyMission myMission = MyMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(MissionStatus.IN_PROGRESS)
                .identifiedNumber(UUID.randomUUID().toString())
                .build();
        return myMissionRepository.save(myMission).getId();
    }
}
