package com.thuan.hibernate.entity;

import java.util.List;

import com.thuan.hibernate.annotation.ValidPassengerCount;

@ValidPassengerCount
public class Car {
	private int seatCount;

	private List<Person> passengers;

	public Car() {
		super();
	}

	public Car(int seatCount, List<Person> passengers) {
		super();
		this.seatCount = seatCount;
		this.passengers = passengers;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public List<Person> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Person> passengers) {
		this.passengers = passengers;
	}

}
