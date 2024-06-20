package com.thuan.hibernate.service;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.thuan.hibernate.annotation.ConsistentDateParameters;

public class BookingService {

	@ConsistentDateParameters
	public void book(@NotNull LocalDate startDate, @NotNull LocalDate endDate) {
		System.out.println("Booking from " + startDate + " to " + endDate);
	}
}
