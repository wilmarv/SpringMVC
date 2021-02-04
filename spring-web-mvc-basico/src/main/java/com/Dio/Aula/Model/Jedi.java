package com.Dio.Aula.Model;

import org.springframework.lang.NonNull;

public class Jedi {
	@NonNull
    private String name;
    private String lastName;

	public Jedi() {
		// TODO Auto-generated constructor stub
	}
	public Jedi(final String name,final String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
