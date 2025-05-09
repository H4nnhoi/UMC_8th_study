package com.example.umc8th.service.food_type;

import com.example.umc8th.domain.foodType.PreferFoodType;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodTypeQueryServiceImpl implements FoodTypeQueryService{

    private final MemberRepository memberRepository;


    @Override
    public List<PreferFoodType> findPreferFoodTypeList(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found member"));

        return member.getPreferFoodTypeList();
    }
}
