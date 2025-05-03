package com.example.umc8th.service.restaurant;

import com.example.umc8th.domain.foodType.FoodType;
import com.example.umc8th.domain.member.Gender;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.member.MemberStatus;
import com.example.umc8th.domain.member.Role;
import com.example.umc8th.domain.region.Region;
import com.example.umc8th.domain.restaurant.Restaurant;
import com.example.umc8th.repository.foodtype.FoodTypeRepository;
import com.example.umc8th.repository.MemberRepository;
import com.example.umc8th.repository.RegionRepository.RegionRepository;
import com.example.umc8th.repository.restaurant.RestaurantRepository;
import com.example.umc8th.service.DatabaseCleanUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class RestaurantQueryServiceTest {

    @Autowired
    RestaurantQueryService restaurantQueryService;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    FoodTypeRepository foodTypeRepository;
    @Autowired
    DatabaseCleanUp databaseCleanUp;

    Member member1;
    Member member2;

    Region region1;

    FoodType foodType1;

    Restaurant restaurant1;
    Restaurant restaurant2;
    Restaurant restaurant3;
    Restaurant restaurant4;
    Restaurant restaurant5;

    @BeforeEach
    void setup() {
        region1 = Region.builder()
                .region("seoul")
                .build();
        regionRepository.save(region1);

        foodType1 = FoodType.builder()
                .name("Korean Food")
                .build();

        foodTypeRepository.save(foodType1);

        member1 = Member.builder()
                .address("no-won")
                .email("wjdgks3264@naver.com")
                .name("jeong-han")
                .nickname("han")
                .status(MemberStatus.ACTIVE)
                .point(10)
                .role(Role.ROLE_USER)
                .gender(Gender.MALE)
                .build();

        member2 = Member.builder()
                .address("no-won")
                .email("wjdgks2972@naver.com")
                .name("jeong-han")
                .nickname("hanb")
                .status(MemberStatus.ACTIVE)
                .point(15)
                .role(Role.ROLE_USER)
                .gender(Gender.MALE)
                .build();

        memberRepository.saveAll(List.of(member1, member2));

        restaurant1 = Restaurant.builder()
                .name("name1")
                .address("address1")
                .region(region1)
                .foodType(foodType1)
                .imgUrl("image.jpg")
                .score(4.0F)
                .storeOwner(member1)
                .build();

        restaurant2 = Restaurant.builder()
                .name("name1")
                .address("address1")
                .region(region1)
                .foodType(foodType1)
                .imgUrl("image.jpg")
                .score(3.0F)
                .storeOwner(member1)
                .build();

        restaurant3 = Restaurant.builder()
                .name("name1")
                .address("address1")
                .region(region1)
                .foodType(foodType1)
                .imgUrl("image.jpg")
                .score(4.0F)
                .storeOwner(member1)
                .build();

        restaurant4 = Restaurant.builder()
                .name("name1")
                .address("address1")
                .region(region1)
                .foodType(foodType1)
                .imgUrl("image.jpg")
                .score(3.2F)
                .storeOwner(member1)
                .build();


        restaurant5 = Restaurant.builder()
                .name("name1")
                .address("address1")
                .region(region1)
                .foodType(foodType1)
                .imgUrl("image.jpg")
                .score(2.0F)
                .storeOwner(member1)
                .build();

        restaurantRepository.saveAll(List.of(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5));

    }

    @AfterEach
    void cleanUp() {
        databaseCleanUp.truncateAllEntity();
    }

    @Test
    @DisplayName("음식점의 이름과 점수를 통해 원하는 음식점 데이터를 모두 조회합니다.")
    void findRestaurantsByNameAndScore(){
        //given
        Float targetScore = 4.0F;
        String targetName = "name1";
        //when
        List<Restaurant> result = restaurantQueryService.findRestaurantsByNameAndScore(targetName, targetScore);
        //then
        assertThat(result.size()).isEqualTo(2);
    }

}