package com.thuan.hibernate.annotation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentDateParametersValidator implements ConstraintValidator<ConsistentDateParameters, Object[]> {

	@Override
	public boolean isValid(Object[] value, ConstraintValidatorContext context) {
		if (value.length != 2) {
			throw new IllegalArgumentException("Illegal method signature");
		}

		// leave null-checking to @NotNull on individual parameters
		if (value[0] == null || value[1] == null) {
			return true;
		}

		if (!(value[0] instanceof LocalDate) || !(value[1] instanceof LocalDate)) {
			throw new IllegalArgumentException("Illegal method signature, expected two " + "parameters of type Date.");
		}

		return ((LocalDate) value[0]).isBefore((LocalDate) value[1]);
	}

}
