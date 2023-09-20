package com.thuan.hibernate.entity;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.thuan.hibernate.annotation.Phone;

public class User {
	@NotNull(message = "Please enter id")
	private Integer id;

	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@NotEmpty(message = "Please enter name")
	private String name;

	@NotNull(message = "tuoi khong duoc phep null")
	@Range(min = 10, max = 150, message = "Tuoi phai nam trong {min} {max}")
	private int age;

	@Email(message = "{user.email.invalid}")
	@NotEmpty(message = "Please enter email")
	private String email;

	@FutureOrPresent(message = "Vui long nhap ngay hien tai hoac tuong lai")
	private LocalDate date;

	@Phone(message = "số điện thoại không đúng")
	private String phone;

	public User(Integer id, String name, int age, String email, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.date = date;
	}

	public User(@NotNull(message = "Please enter id") Integer id,
			@Size(max = 20, min = 3, message = "{user.name.invalid}") @NotEmpty(message = "Please enter name") String name,
			@NotNull(message = "tuoi khong duoc phep null") @Range(min = 10, max = 150, message = "Tuoi phai nam trong {min} {max}") int age,
			@Email(message = "{user.email.invalid}") @NotEmpty(message = "Please enter email") String email,
			@FutureOrPresent(message = "Vui long nhap ngay hien tai hoac tuong lai") LocalDate date, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.date = date;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
