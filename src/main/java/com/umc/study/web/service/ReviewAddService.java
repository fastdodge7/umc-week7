package com.umc.study.web.service;

import com.umc.study.converter.ReviewConverter;
import com.umc.study.domain.Member;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.web.dto.MemberRequestDTO;
import com.umc.study.web.dto.ReviewRequestDTO;
import com.umc.study.web.dto.ReviewResponseDTO;
import com.umc.study.web.repository.MemberRepository;
import com.umc.study.web.repository.ReviewRepository;
import com.umc.study.web.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewAddService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Review addReviewToStore(ReviewRequestDTO.ReviewDto request) {
        Member author = memberRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게"));

        Review review = ReviewConverter.toReview(request, author, store);
        store.getReviewList().add(review);
        return reviewRepository.save(review);
    }
}
