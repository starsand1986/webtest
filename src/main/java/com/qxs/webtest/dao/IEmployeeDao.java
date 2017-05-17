package com.qxs.webtest.dao;

import org.springframework.stereotype.Repository;

import com.qxs.webtest.model.Employee;

@Repository
public interface IEmployeeDao {
	void insertEmployee(Employee employee);
	
	void testInsert(String value);
}
