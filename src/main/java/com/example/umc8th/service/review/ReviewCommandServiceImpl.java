package com.example.umc8th.service.review;

import com.example.umc8th.apiPayload.code.status.ErrorStatus;
import com.example.umc8th.apiPayload.exception.handler.MemberHandler;
import com.example.umc8th.apiPayload.exception.handler.RestaurantHandler;
import com.example.umc8th.domain.member.Member;
import com.example.umc8th.domain.restaurant.Restaurant;
import com.example.umc8th.domain.review.Review;
import com.example.umc8th.repository.member.MemberRepository;
import com.example.umc8th.repository.restaurant.RestaurantRepository;
import com.example.umc8th.repository.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    @Override
    public Long writeReview(Long restaurantId, Long memberId, String content) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Review review = Review.builder()
                .content(content)
                .member(member)
                .restaurant(restaurant)
                .build();
        return reviewRepository.save(review).getId();
    }
}
