package com.umc.study.web.dto;

import com.umc.study.domain.Store;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class MissionDTO{
        @NotBlank
        private String title;

        private String content;

        @NotBlank
        private LocalDateTime deadline;

        @NotBlank
        private Long point;

        @NotBlank
        private Long storeId;
    }
}