package com.revature.revshop.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//public class CustomValidator implements ConstraintValidator<CustomValidation, String> {
//
//    @Override
//    public void initialize(CustomValidation constraintAnnotation) {
//        // Initialization code if necessary
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (value == null || value.isEmpty()) {
//            return false;
//        }
//        // Custom validation logic
//        return value.matches("[a-zA-Z]+"); // Example: Only allow alphabetic characters
//    }
//}
