package com.thuan.hibernate.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.thuan.hibernate.entity.Car;

public class ValidPassengerCountValidator implements ConstraintValidator<ValidPassengerCount, Car> {

	@Override
	public boolean isValid(Car car, ConstraintValidatorContext context) {
		if (car == null) {
			return true;
		}

		return car.getPassengers().size() <= car.getSeatCount();
	}

}
