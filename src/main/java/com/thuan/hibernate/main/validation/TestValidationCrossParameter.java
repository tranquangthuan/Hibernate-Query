package com.thuan.hibernate.main.validation;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.thuan.hibernate.service.BookingService;

public class TestValidationCrossParameter {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// Create ValidatorFactory which returns validator
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// It validates bean instances
		Validator validator = factory.getValidator();

		BookingService bookingService = new BookingService();

		// ngày hiện tại
		LocalDate startDate = LocalDate.now();
		// ngày hôm qua
		LocalDate endDate = LocalDate.now().minusDays(1);

		Set<ConstraintViolation<BookingService>> violations = validator.forExecutables().validateParameters(
				bookingService, BookingService.class.getMethod("book", LocalDate.class, LocalDate.class),
				new Object[] { startDate, endDate });

		if (violations.isEmpty()) {
			bookingService.book(startDate, endDate);
		} else {
			for (ConstraintViolation<BookingService> violation : violations) {
				System.out.println(violation.getMessage());
			}
		}
	}

}
