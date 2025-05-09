package com.example.umc8th.service.food_type;

import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.foodType.PreferFoodType;
import com.example.umc8th.domain.member.Gender;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.member.MemberStatus;
import com.example.umc8th.domain.member.Role;
import com.example.umc8th.repository.foodtype.FoodTypeRepository;
import com.example.umc8th.repository.foodtype.PreferFoodTypeRepository;
import com.example.umc8th.repository.member.MemberRepository;
import com.example.umc8th.service.DatabaseCleanUp;
import com.example.umc8th.web.dto.foodtype.RequestFoodTypeDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class FoodTypeCommandServiceTest {

    @Autowired
    FoodTypeCommandService foodTypeCommandService;
    @Autowired
    FoodTypeQueryService foodTypeQueryService;
    @Autowired
    FoodTypeRepository foodTypeRepository;
    @Autowired
    PreferFoodTypeRepository preferFoodTypeRepository;
    @Autowired
    DatabaseCleanUp databaseCleanUp;
    @Autowired
    MemberRepository memberRepository;

    Member member1;

    @BeforeEach
    void setup() {
        member1 = Member.builder()
                .name("name")
                .gender(Gender.MALE)
                .role(Role.ROLE_USER)
                .point(10)
                .email("wjdgks3264@naver.com")
                .status(MemberStatus.ACTIVE)
                .nickname("nickname")
                .build();
        memberRepository.save(member1);
    }

    @AfterEach
    void cleanUp() {
        databaseCleanUp.truncateAllEntity();
    }

    @Test
    @DisplayName("음식 카테고리를 저장합니다.")
    void saveFoodCategory(){
        //given
        RequestFoodTypeDto koreanFood = RequestFoodTypeDto.builder()
                .name("Korean Food")
                .build();

        //when
        Long foodTypeId = foodTypeCommandService.registerFoodType(koreanFood);

        //then
        Optional<FoodType> foodTypeOptional = foodTypeRepository.findById(foodTypeId);
        assertThat(foodTypeOptional).isPresent();
        FoodType foodType = foodTypeOptional.get();
        assertThat(foodType.getName()).isEqualTo(koreanFood.getName());
    }

    @Test
    @DisplayName("특정 유저가 선호하는 음식타입을 추가합니다.")
    void addPreferFoodType(){
        //given
        FoodType foodType = FoodType.builder()
                .name("foodType")
                .build();
        foodTypeRepository.save(foodType);

        PreferFoodType preferFoodType = PreferFoodType.builder()
                .member(member1)
                .foodType(foodType)
                .build();
        log.info("before = {}", preferFoodType.getId());
        //when
        PreferFoodType save = preferFoodTypeRepository.save(preferFoodType);
        //then
        log.info("after = {}", preferFoodType.getId());
        assertThat(save.getId()).isEqualTo(preferFoodType.getId());
    }

    @Test
    @DisplayName("test")
    void addPreferFoodTypeByService(){
        //given
        FoodType foodType = FoodType.builder()
                .name("foodType")
                .build();
        foodTypeRepository.save(foodType);
        //when
        foodTypeCommandService.addFoodTypeOfMember(foodType.getId(), member1.getId());
        //then
        List<PreferFoodType> all = preferFoodTypeRepository.findAll();
        assertThat(all.size()).isOne();
//        List<PreferFoodType> preferFoodTypeList = member1.getPreferFoodTypeList();
//        assertThat(preferFoodTypeList.size()).isOne();
    }

    @Test
    @DisplayName("N+1문제가 무엇인지 확인한다.")
    void whatIsN_plusOne(){
        //given
        FoodType korean = FoodType.builder()
                .name("Korean")
                .build();
        FoodType japanese = FoodType.builder()
                .name("Japanese")
                .build();
        FoodType chinese = FoodType.builder()
                .name("Chinese")
                .build();
        FoodType american = FoodType.builder()
                .name("American")
                .build();
        foodTypeRepository.saveAll(List.of(korean, japanese, chinese, american));

        foodTypeCommandService.addFoodTypeOfMember(korean.getId(), member1.getId());
        foodTypeCommandService.addFoodTypeOfMember(japanese.getId(), member1.getId());
        foodTypeCommandService.addFoodTypeOfMember(chinese.getId(), member1.getId());
        foodTypeCommandService.addFoodTypeOfMember(american.getId(), member1.getId());

        //when
        List<PreferFoodType> preferFoodTypeList = foodTypeQueryService.findPreferFoodTypeList(member1.getId());
        //then
        assertThat(preferFoodTypeList.size()).isEqualTo(4);

    }

}