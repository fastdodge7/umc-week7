package com.umc.study.converter;

import com.umc.study.domain.Member;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.domain.common.Gender;
import com.umc.study.web.dto.MemberRequestDTO;
import com.umc.study.web.dto.MemberResponseDTO;
import com.umc.study.web.dto.ReviewRequestDTO;
import com.umc.study.web.dto.ReviewResponseDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDto request, Member author, Store store){

        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .stars(request.getStars())
                .author(author)
                .store(store)
                .build();
    }
}
