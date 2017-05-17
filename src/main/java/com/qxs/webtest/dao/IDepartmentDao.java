package com.qxs.webtest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qxs.webtest.model.Department;

@Repository
public interface IDepartmentDao {
	void insertDepartment(Department dept);
	
	List<Department> getAllDepartments();
	
	Department getDepartmentById(Long id);
	
	List<Department> getSubDepartments(long id);
	
	Department getParentDepartment(long id);
	
	void updateDepartment(Department dept);
	void updateParentDepartment(long id);
	
	void removeDepartment(long id);
}
