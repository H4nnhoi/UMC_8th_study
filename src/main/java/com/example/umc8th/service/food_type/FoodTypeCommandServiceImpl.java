package com.example.umc8th.service.food_type;

import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.foodType.PreferFoodType;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.mission.Mission;
import com.example.umc8th.domain.mission.MissionStatus;
import com.example.umc8th.domain.mission.MyMission;
import com.example.umc8th.repository.FoodTypeRepository;
import com.example.umc8th.repository.MemberRepository;
import com.example.umc8th.repository.PreferFoodTypeRepository;
import com.example.umc8th.web.dto.foodtype.RequestFoodTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodTypeCommandServiceImpl implements FoodTypeCommandService{

    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;
    private final PreferFoodTypeRepository preferFoodTypeRepository;

    @Override
    public Long registerFoodType(RequestFoodTypeDto dto) {
        FoodType foodType = FoodType.builder()
                .name(dto.getName())
                .build();
        return foodTypeRepository.save(foodType).getId();
    }

    @Override
    public Long addFoodTypeOfMember(Long foodTypeId, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found member"));
        FoodType foodType = foodTypeRepository.findById(foodTypeId)
                .orElseThrow(() -> new RuntimeException("not found foodType"));
        PreferFoodType preferFoodType = PreferFoodType.builder()
                .foodType(foodType)
                .member(member)
                .build();
        return preferFoodTypeRepository.save(preferFoodType).getId();
    }
}
