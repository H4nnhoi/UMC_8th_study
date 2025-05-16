package com.example.umc8th.repository.review;

import com.example.umc8th.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
