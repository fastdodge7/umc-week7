package com.umc.study.web.service;

import com.umc.study.converter.MissionConverter;
import com.umc.study.converter.ReviewConverter;
import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.web.dto.MissionRequestDTO;
import com.umc.study.web.dto.ReviewRequestDTO;
import com.umc.study.web.repository.MemberRepository;
import com.umc.study.web.repository.MissionRepository;
import com.umc.study.web.repository.ReviewRepository;
import com.umc.study.web.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionAddService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Mission addMissionToStore(MissionRequestDTO.MissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게"));

        Mission mission = MissionConverter.toMission(request, store);
        store.getMissionList().add(mission);
        return missionRepository.save(mission);
    }

    @Transactional
    public Mission challengeMission(MissionRequestDTO.MissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게"));

        Mission mission = MissionConverter.toMission(request, store);
        store.getMissionList().add(mission);
        return missionRepository.save(mission);
    }
}
