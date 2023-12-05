package com.umc.study.converter;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.web.dto.MissionRequestDTO;
import com.umc.study.web.dto.MissionResponseDTO;
import com.umc.study.web.dto.ReviewRequestDTO;
import com.umc.study.web.dto.ReviewResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.MissionAddResultDTO toMissionAddResultDTO(Mission mission){
        return MissionResponseDTO.MissionAddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionDTO request, Store store){

        return Mission.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .deadline(request.getDeadline())
                .point(request.getPoint())
                .store(store)
                .build();
    }
}
