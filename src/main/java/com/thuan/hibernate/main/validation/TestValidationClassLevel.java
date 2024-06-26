package com.thuan.hibernate.main.validation;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.thuan.hibernate.entity.Car;
import com.thuan.hibernate.entity.Person;

public class TestValidationClassLevel {

	public static void main(String[] args) {
		// Create ValidatorFactory which returns validator
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// It validates bean instances
		Validator validator = factory.getValidator();

		Car car = new Car(1, List.of(new Person(), new Person(), new Person()));
		Set<ConstraintViolation<Car>> carViolations = validator.validate(car);
		// Show errors
		if (carViolations.size() > 0) {
			for (ConstraintViolation<Car> violation : carViolations) {
				System.out.println(violation.getMessage());
			}
		} else {
			System.out.println("Valid Object");
		}
	}

}
