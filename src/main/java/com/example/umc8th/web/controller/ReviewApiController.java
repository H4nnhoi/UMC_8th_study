package com.example.umc8th.web.controller;

import com.example.umc8th.apiPayload.ApiResponse;
import com.example.umc8th.service.review.ReviewCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewApiController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/restaurants/{restaurantId}/members/{memberId}")
    public ApiResponse<Long> writeReview(@PathVariable Long restaurantId,
                                         @PathVariable Long memberId,
                                         @RequestParam String content) {
        return ApiResponse.onSuccess(reviewCommandService.writeReview(restaurantId, memberId, content));
    }
}
