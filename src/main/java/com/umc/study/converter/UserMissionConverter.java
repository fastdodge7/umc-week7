package com.umc.study.converter;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.domain.mapping.UserMissions;
import com.umc.study.web.dto.ReviewRequestDTO;
import com.umc.study.web.dto.ReviewResponseDTO;
import com.umc.study.web.dto.UserMissionRequestDTO;
import com.umc.study.web.dto.UserMissionResponseDTO;

public class UserMissionConverter {

    public static UserMissionResponseDTO.UserMissionAddResult toUserMissionAddResult(UserMissions userMissions){
        return UserMissionResponseDTO.UserMissionAddResult.builder()
                .verifyingId(userMissions.getMission_VerifyingId())
                .createdAt(userMissions.getCreatedAt())
                .build();
    }

    public static UserMissions toUserMissions(UserMissionRequestDTO.UserMissionDTO request, Member member, Mission mission){

        return UserMissions.builder()
                .missionState("Challenging")
                .mission_VerifyingId("Random_ID")
                .mission(mission)
                .member(member)
                .build();
    }
}
