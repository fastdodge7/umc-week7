package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.converter.ReviewConverter;
import com.umc.study.converter.TempConverter;
import com.umc.study.web.dto.ReviewRequestDTO;
import com.umc.study.web.dto.ReviewResponseDTO;
import com.umc.study.web.dto.TempResponse;
import com.umc.study.web.service.ReviewAddService;
import com.umc.study.web.service.TempQueryService;
import com.umc.study.web.validation.ExistStore;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewAddService reviewAddService;

    @PostMapping("/stores/{storeId}/review")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> addReview(
            @PathVariable("storeId") @ExistStore Long storeId,
            @Valid ReviewRequestDTO.ReviewDto dto){
        reviewAddService.addReviewToStore(dto);
        return ApiResponse.onSuccess(
                ReviewConverter.toReviewResultDTO(
                        reviewAddService.addReviewToStore(dto)));
    }
}