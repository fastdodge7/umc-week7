package com.umc.study.web.service;

import com.umc.study.converter.ReviewConverter;
import com.umc.study.converter.UserMissionConverter;
import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.domain.mapping.UserMissions;
import com.umc.study.web.dto.ReviewRequestDTO;
import com.umc.study.web.dto.UserMissionRequestDTO;
import com.umc.study.web.dto.UserMissionRequestDTO.UserMissionDTO;
import com.umc.study.web.repository.MemberRepository;
import com.umc.study.web.repository.MissionRepository;
import com.umc.study.web.repository.ReviewRepository;
import com.umc.study.web.repository.StoreRepository;
import com.umc.study.web.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserMissionService {
    private final UserMissionRepository userMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Transactional
    public UserMissions addChallengingMission(UserMissionRequestDTO.UserMissionDTO request) {
        Member member = memberRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션"));

        UserMissions userMissions = UserMissionConverter.toUserMissions(request, member, mission);
        return userMissionRepository.save(userMissions);
    }

    @Transactional
    public Page<UserMissions> getMyMission(Long id, int pageNum) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));
        return userMissionRepository.findByMember(member, PageRequest.of(pageNum, 10));
    }
}
