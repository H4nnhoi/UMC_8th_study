package com.example.umc8th.service.restaurant;

import com.example.umc8th.apiPayload.code.status.ErrorStatus;
import com.example.umc8th.apiPayload.exception.handler.MemberHandler;
import com.example.umc8th.apiPayload.exception.handler.RegionHandler;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.region.Region;
import com.example.umc8th.domain.restaurant.Restaurant;
import com.example.umc8th.repository.member.MemberRepository;
import com.example.umc8th.repository.region.RegionRepository;
import com.example.umc8th.repository.restaurant.RestaurantRepository;
import com.example.umc8th.service.region.RegionCommandService;
import com.example.umc8th.web.dto.converter.RestaurantConverter;
import com.example.umc8th.web.dto.region.RequestRestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Long registerRestaurantInRegion(Long regionId, Long memberId, RequestRestaurantDto.RegisterDto dto) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Restaurant restaurant = RestaurantConverter.registerToRestaurantEntity(dto);
        restaurant.registerRegionAndOwner(region, member);

        return restaurantRepository.save(restaurant).getId();
    }
}
