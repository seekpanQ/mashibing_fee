package com.mashibing.apipassenger.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class VehicleTypeCheckValidator implements ConstraintValidator<VehicleTypeCheck, String> {
    private List<String> vehicleTypeCheckValue = null;

    @Override
    public void initialize(VehicleTypeCheck constraintAnnotation) {
        vehicleTypeCheckValue = Arrays.asList(constraintAnnotation.vehiecleTypeValue());
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("自定义注解校验开始");
        if (vehicleTypeCheckValue.contains(value)) {
            return true;
        }
        return false;
    }
}
