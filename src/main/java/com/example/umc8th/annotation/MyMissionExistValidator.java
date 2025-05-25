package com.example.umc8th.annotation;

import com.example.umc8th.apiPayload.code.status.ErrorStatus;
import com.example.umc8th.domain.mission.MyMission;
import com.example.umc8th.repository.mission.MyMissionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MyMissionExistValidator implements ConstraintValidator<ExistMyMission, Map.Entry<Long, Long>> {

    private final MyMissionRepository myMissionRepository;

    @Override
    public void initialize(ExistMyMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Map.Entry<Long, Long> memberAndMission, ConstraintValidatorContext context) {
        boolean isValid = myMissionRepository
                .existsByMemberIdAndMissionId(memberAndMission.getKey(), memberAndMission.getValue());


        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(String.valueOf(ErrorStatus.MY_MISSION_EXIST)).addConstraintViolation();
        }

        return isValid;
    }
}
