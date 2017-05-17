package com.qxs.webtest.model;

public enum Gender {
	MALE("Male"), FEMALE("Female");
	
	private String value;
	
	private Gender(String value){
		this.value = value;
	}
}
