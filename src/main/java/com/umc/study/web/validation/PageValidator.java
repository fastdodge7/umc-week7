package com.umc.study.web.validation;

import com.umc.study.web.repository.StoreRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageValidator implements ConstraintValidator<PageCheck, int> {
    private final StoreRepository storeRepository;

    @Override
    public void initialize(PageCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(int value, ConstraintValidatorContext context) {
        return value > 0;
    }
}
