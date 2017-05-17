package com.qxs.webtest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qxs.webtest.model.Department;
import com.qxs.webtest.service.DepartmentService;

@RestController
@RequestMapping(value="/v1")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@RequestMapping(value="/departments", method=RequestMethod.POST)
	public void createDepartment(@RequestBody Department dept){

		deptService.createDepartment(dept);
	}
	
	@RequestMapping(value="/departments/list", method=RequestMethod.GET)
	public List<Department> getAllDepartments(){

		return deptService.getAllDepartments();
	}
	
	@RequestMapping(value="/departments/details/{id}", method=RequestMethod.GET)
	public Department getDepartmentById(@PathVariable long id){

		return deptService.getDepartmentById(id);
	}
	
	@RequestMapping(value="/departments/sub/{id}", method=RequestMethod.GET)
	public List<Department> getSubDepartment(@PathVariable long id){

		return deptService.getSubDepartments(id);
	}
	
	@RequestMapping(value="/departments/parent/{id}", method=RequestMethod.GET)
	public Department getParentDepartment(@PathVariable long id){

		return deptService.getParentDepartment(id);
	}
	
	@RequestMapping(value="/departments/{id}", method=RequestMethod.PUT)
	public void updateDepartment(Department dept){

		deptService.updateDepartment(dept);
	}
	
	@RequestMapping(value="/departments/{id}", method=RequestMethod.DELETE)
	public void removeDepartment(@PathVariable long id){

		deptService.removeDepartment(id);
	}
	
}
