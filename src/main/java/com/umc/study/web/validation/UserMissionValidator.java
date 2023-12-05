package com.umc.study.web.validation;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.mapping.UserMissions;
import com.umc.study.web.dto.UserMissionRequestDTO;
import com.umc.study.web.dto.UserMissionRequestDTO.UserMissionDTO;
import com.umc.study.web.repository.MemberRepository;
import com.umc.study.web.repository.MissionRepository;
import com.umc.study.web.repository.UserMissionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMissionValidator implements ConstraintValidator<IsAlreadyChallenging, UserMissionRequestDTO.UserMissionDTO> {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    @Override
    public void initialize(IsAlreadyChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserMissionRequestDTO.UserMissionDTO value, ConstraintValidatorContext context) {
        Member member = memberRepository.findById(value.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저"));
        Mission mission = missionRepository.findById(value.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션"));
        List<UserMissions> lst = userMissionRepository.findByMemberAndMission(member, mission);
        if (lst.isEmpty())
            return true;
        return lst.stream()
                .allMatch(element -> element.getMissionState().equals("COMPLETE"));
    }
}
