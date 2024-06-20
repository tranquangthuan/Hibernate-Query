package com.thuan.hibernate.main.validation;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;

import com.thuan.hibernate.entity.User;

public class TestValidationCustomMessage {

	public static void main(String[] args) {
		// Custom Validator with message file name not default
		// ValidationMessages.properties
		Validator validatorCustom = Validation.byDefaultProvider().configure()
				.messageInterpolator(new ResourceBundleMessageInterpolator(
						new AggregateResourceBundleLocator(Arrays.asList("messages", "otherMessages"))))
				.buildValidatorFactory().getValidator();

		User user = new User(1, "A", 210, "@gmail.com", LocalDate.of(2022, 1, 1));
		Set<ConstraintViolation<User>> constraintViolations = validatorCustom.validate(user);
		// Show errors
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<User> violation : constraintViolations) {
				System.out.println(violation.getMessage());
			}
		} else {
			System.out.println("Valid Object");
		}
	}

}
