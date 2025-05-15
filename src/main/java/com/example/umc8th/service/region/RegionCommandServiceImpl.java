package com.example.umc8th.service.region;

import com.example.umc8th.apiPayload.code.status.ErrorStatus;
import com.example.umc8th.apiPayload.exception.handler.RestaurantHandler;
import com.example.umc8th.domain.region.Region;
import com.example.umc8th.domain.restaurant.Restaurant;
import com.example.umc8th.repository.region.RegionRepository;
import com.example.umc8th.repository.restaurant.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService{

    private final RegionRepository regionRepository;

    @Override
    public Long registerRegion(String region) {
        Region build = Region.builder()
                .region(region)
                .build();
        return regionRepository.save(build).getId();
    }
}
