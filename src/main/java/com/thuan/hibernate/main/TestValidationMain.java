package com.thuan.hibernate.main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;

import com.thuan.hibernate.entity.User;

public class TestValidationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create ValidatorFactory which returns validator
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// It validates bean instances
		Validator validator = factory.getValidator();

		// Custom Validator with message file name not default
		// ValidationMessages.properties
		Validator validatorCustom = Validation.byDefaultProvider().configure()
				.messageInterpolator(new ResourceBundleMessageInterpolator(
						new AggregateResourceBundleLocator(Arrays.asList("messages", "otherMessages"))))
				.buildValidatorFactory().getValidator();

		User user = new User(1, "A", 210, "@gmail.com", LocalDate.of(2022, 1, 1));
		User user2 = new User(1, "A", 210, "@gmail.com", LocalDate.of(2022, 1, 1), "1999123456");
		Set<ConstraintViolation<User>> constraintViolations = validatorCustom.validate(user2);
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
