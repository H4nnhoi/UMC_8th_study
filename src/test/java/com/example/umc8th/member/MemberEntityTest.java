package com.example.umc8th.member;

import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.foodType.PreferFoodType;
import com.example.umc8th.domain.member.Gender;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.repository.*;
import com.example.umc8th.repository.foodtype.FoodTypeRepository;
import com.example.umc8th.repository.foodtype.PreferFoodTypeRepository;
import com.example.umc8th.service.DatabaseCleanUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberEntityTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MissionRepository missionRepository;
    @Autowired
    MyMissionRepository myMissionRepository;
    @Autowired
    FoodTypeRepository foodTypeRepository;
    @Autowired
    PreferFoodTypeRepository preferFoodTypeRepository;
    @Autowired
    DatabaseCleanUp databaseCleanUp;

    @BeforeEach
    void setup() {

    }

    @AfterEach
    void cleanUp() {
        databaseCleanUp.truncateAllEntity();
    }

    @Test
    @DisplayName("멤버 생성")
    void createMember(){
        //given
        Member member = Member.builder()
                .address("address")
                .email("email")
                .name("name")
                .gender(Gender.MALE)
                .inactiveDate(LocalDate.EPOCH)
                .nickname("nickname")
                .point(0)
                .build();
        //when
        memberRepository.save(member);
        //then
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isOne();

    }

    @Test
//    @Transactional
    @DisplayName("멤버 생성 및 연관관계 생성")
    void createMemberAndMakeRelations(){
        //given
        // create member
        Member member = Member.builder()
                .address("address")
                .email("email")
                .name("name")
                .gender(Gender.MALE)
                .inactiveDate(LocalDate.EPOCH)
                .nickname("nickname")
                .point(0)
                .build();
        memberRepository.save(member);
        // create food type
        FoodType foodType = FoodType.builder()
                .name("A")
                .build();
        foodTypeRepository.save(foodType);
        // link member - foodType
        PreferFoodType preferFoodType = PreferFoodType.builder()
                .member(member)
                .foodType(foodType)
                .build();
        //when
        preferFoodTypeRepository.save(preferFoodType);
        //then
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isOne();
        assertThat(all.get(0).getPreferFoodTypeList().size()).isOne();

    }
}
