package com.thuan.hibernate.main.validation;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.thuan.hibernate.entity.Car;
import com.thuan.hibernate.entity.Person;
import com.thuan.hibernate.entity.User;

public class TestValidation {

	public static void main(String[] args) {
		// Create ValidatorFactory which returns validator
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// It validates bean instances
		Validator validator = factory.getValidator();

		User user = new User(1, "A", 210, "@gmail.com", LocalDate.of(2022, 1, 1));
		User validUser = new User(1, "ABC", 20, "thuan@gmail.com", LocalDate.now(), "0982992593");
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(validUser);
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
