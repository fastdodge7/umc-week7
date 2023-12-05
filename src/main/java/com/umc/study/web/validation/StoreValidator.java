package com.umc.study.web.validation;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.mapping.UserMissions;
import com.umc.study.web.dto.UserMissionRequestDTO.UserMissionDTO;
import com.umc.study.web.repository.MemberRepository;
import com.umc.study.web.repository.MissionRepository;
import com.umc.study.web.repository.StoreRepository;
import com.umc.study.web.repository.UserMissionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return storeRepository.existsById(value);
    }
}
