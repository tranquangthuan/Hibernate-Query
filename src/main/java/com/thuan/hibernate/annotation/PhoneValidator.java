package com.thuan.hibernate.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && value.matches("[0-9]+") && value.length() == 10;
	}

}
