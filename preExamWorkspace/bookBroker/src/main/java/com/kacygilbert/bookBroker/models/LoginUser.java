package com.kacygilbert.bookBroker.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginUser {

	@NotNull
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotNull
	private String password;
	
	public LoginUser() { }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
