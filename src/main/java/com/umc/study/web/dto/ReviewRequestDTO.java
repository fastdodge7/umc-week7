package com.umc.study.web.dto;

import com.umc.study.domain.Member;
import com.umc.study.domain.Store;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDto{
        @NotBlank
        private String title;

        private String content;

        @NotBlank
        private Float stars;

        @NotBlank
        private Long authorId;

        @NotBlank
        private Long storeId;
    }
}