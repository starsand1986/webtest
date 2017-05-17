package com.qxs.webtest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qxs.webtest.dao.IDepartmentDao;
import com.qxs.webtest.model.Department;
import com.qxs.webtest.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private IDepartmentDao deptDao;
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	public void createDepartment(Department dept){
		logger.info("ok");
		deptDao.insertDepartment(dept);
	}
	@Override
	public List<Department> getAllDepartments() {
		List<Department> depts = deptDao.getAllDepartments();
		return depts;
	}
	@Override
	public Department getDepartmentById(long id) {
		Department dept = deptDao.getDepartmentById(id);
		return dept;
	}
	@Override
	public List<Department> getSubDepartments(long id) {

		return deptDao.getSubDepartments(id);
	}
	@Override
	public Department getParentDepartment(long id) {

		return deptDao.getParentDepartment(id);
	}

	@Transactional
	public void updateDepartment(Department dept) {	
		deptDao.updateDepartment(dept);
	}

	@Transactional
	public void removeDepartment(long id) {

		deptDao.updateParentDepartment(id);
		deptDao.removeDepartment(id);
		
	}
}
