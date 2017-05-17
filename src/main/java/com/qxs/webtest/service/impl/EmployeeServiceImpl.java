package com.qxs.webtest.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxs.webtest.dao.IEmployeeDao;
import com.qxs.webtest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private IEmployeeDao employeeDao;
	
	public void testInsert(String value){
		System.out.println(value);
		employeeDao.testInsert(value);
	}
}
