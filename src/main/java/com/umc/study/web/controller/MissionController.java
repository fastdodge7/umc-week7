package com.umc.study.web.controller;

import com.umc.study.apiPayload.ApiResponse;
import com.umc.study.converter.MissionConverter;
import com.umc.study.converter.TempConverter;
import com.umc.study.converter.UserMissionConverter;
import com.umc.study.web.dto.MissionRequestDTO;
import com.umc.study.web.dto.MissionResponseDTO;
import com.umc.study.web.dto.TempResponse;
import com.umc.study.web.dto.UserMissionRequestDTO;
import com.umc.study.web.dto.UserMissionRequestDTO.UserMissionDTO;
import com.umc.study.web.dto.UserMissionResponseDTO;
import com.umc.study.web.service.MissionAddService;
import com.umc.study.web.service.TempQueryService;
import com.umc.study.web.service.UserMissionService;
import com.umc.study.web.validation.ExistStore;
import com.umc.study.web.validation.IsAlreadyChallenging;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final UserMissionService userMissionService;
    private final MissionAddService missionAddService;

    @PostMapping("/stores/{storeId}/mission")
    @Operation(summary="특정 포스트에 댓글 등록", description="테스트 중입니다.")
    public ApiResponse<MissionResponseDTO.MissionAddResultDTO> addMissionToStore(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO.MissionDTO dto){

        return ApiResponse.onSuccess(
                MissionConverter.toMissionAddResultDTO(missionAddService.addMissionToStore(dto))
        );
    }

    @PostMapping("/users/{userId}/mission/{missionId}")
    public ApiResponse<UserMissionResponseDTO.UserMissionAddResult> challengeMission(
            @PathVariable("userId") Long userId,
            @PathVariable("userId") Long missionId,
            @RequestBody @IsAlreadyChallenging @Valid UserMissionRequestDTO.UserMissionDTO dto
            ){

        return ApiResponse.onSuccess(
                UserMissionConverter.toUserMissionAddResult(userMissionService.addChallengingMission(dto))
        );
    }
}