package com.qxs.webtest.controller;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qxs.webtest.model.Department;
import com.qxs.webtest.model.TestModel;
import com.qxs.webtest.service.DepartmentService;
import com.qxs.webtest.service.EmployeeService;

@RestController
@RequestMapping(value="/v1/persons")
public class ControllerDemo {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerDemo.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public void getPerson(@PathVariable(value="id") String id){
		System.out.println(id);
//		logger.info(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String postPerson(@PathVariable(value="id") String id){
		System.out.println(id);
//		logger.info(id);
		return id;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public void getPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        //输出字符串
        response.getWriter().append("hello world hahaha");

    }
	
	@RequestMapping(value="/test/callable", method=RequestMethod.GET)
	public String threadTest() throws InterruptedException, ExecutionException{
		ExecutorService pool = Executors.newFixedThreadPool(2);
		try{
			String result = null;
//			FutureTask<String> task = (FutureTask<String>) exc.submit(new Runnable(){
//
//				public void run(){
//					for(int i=0;i<10;i++){
//						try{
//							Thread.sleep(100L);
//						} catch(InterruptedException e){
//							e.printStackTrace();
//						}
//						System.out.println(this.getClass()+"::线程执行中.."+i);
//					}
//				}
//			},result);
//			
//			System.out.println("task return value:" + task.get());
			
			CallableTask ct = new CallableTask();
			FutureTask<String> newTask = (FutureTask<String>)pool.submit(ct);	
			System.out.println("main thread is running");
			result = newTask.get();
			System.out.println("task return value:" + result);
			logger.info("ok");
			employeeService.testInsert("this is value 2");
			return result;
		} finally{
			pool.shutdown();
		}
	}
	
	@RequestMapping(value="/departments", method=RequestMethod.POST)
	public void createDepartment(@RequestBody Department dept){
		logger.info("okokokokokokokok");
		deptService.createDepartment(dept);
	}
	
	@RequestMapping(value="/testmodels", method=RequestMethod.POST)
	public void createTestModel(@RequestBody TestModel tm){
		logger.info("okokokokokokokok");
	}
	
	private class RunnableTask implements Runnable{
		public void run(){
			for(int i=0;i<10;i++){
				try{
					Thread.sleep(100L);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(this.getClass()+"::线程执行中.."+i);
			}
		}
	}
	
	private class CallableTask implements Callable<String>{
		public String call(){
			for(int i=0;i<2;i++){
				try{
					Thread.sleep(1000L);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread()+"::线程执行中.."+i);
			}
			return "success";
		}
	}
	
	

}
