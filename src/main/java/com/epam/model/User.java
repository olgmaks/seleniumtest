package com.epam.model;

import com.epam.testdata.xlsparser.KeyLabel;

public class User {


	@KeyLabel("userEmail")
	private String email;

	@KeyLabel("userPassword")
	private String password;

	public User () {}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (email != null ? !email.equals(user.email) : user.email != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = email != null ? email.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}
}
