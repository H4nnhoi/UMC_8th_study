package com.example.umc8th.member;

import com.example.umc8th.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @BeforeEach
    void setup() {

    }

    @Test
    @DisplayName("멤버 생성")
    void createMember(){
        //given

        //when

        //then

    }

    @Test
    @DisplayName("생성된 멤버와 연관관계를 가진 엔티티를 제거하는 방식 확인 1 : orphanRemoval")
    void checkMemberRelationEntities(){

    }
}
