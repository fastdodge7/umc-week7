package com.umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class UserMissionRequestDTO {

    @Getter
    public static class UserMissionDTO{
        @NotBlank
        private Long userId;

        @NotBlank
        private Long missionId;
    }
}