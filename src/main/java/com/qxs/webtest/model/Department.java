package com.qxs.webtest.model;

public class Department {
	private long id;
	private String name;
	private String location;
	private Employee manager;
	private int openPositions;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public int getOpenPositions() {
		return openPositions;
	}
	public void setOpenPositions(int openPositions) {
		this.openPositions = openPositions;
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + ", openPositions=" + openPositions + "]";
	}
	
	
}
