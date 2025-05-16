package com.example.umc8th.service.review;

public interface ReviewCommandService {

    Long writeReview(Long restaurantId, Long memberId, String content);
}
