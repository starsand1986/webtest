package com.qxs.webtest.service;

import java.util.List;

import com.qxs.webtest.model.Department;

public interface DepartmentService {
	public void createDepartment(Department dept);
	
	public List<Department> getAllDepartments();
	
	public Department getDepartmentById(long id);
	
	public List<Department> getSubDepartments(long id);
	
	public Department getParentDepartment(long id);
	
	public void updateDepartment(Department dept);
	
	public void removeDepartment(long id);
}
