package com.charlie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.api.Dept;
import com.charlie.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/provider")
public class DeptController {

	@Autowired
	private DeptService service;
	
	@RequestMapping(value = "/find/dept/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod  = "getDeptByIdHystrix")
	public Dept getDeptById(@PathVariable("id") long id) {
		Dept dept = this.service.getDept(id);
		if(dept == null)
			throw new RuntimeException("熔断方法出现了异常");
		
		return dept;  
	}
	
	public Dept getDeptByIdHystrix(@PathVariable("id") long id) {
		System.err.println("---------------------------这是熔断方法---------------------------------");
		return new Dept();  
	}
	
	@RequestMapping(value = "/find/dept/list", method = RequestMethod.GET)
	public List<Dept> list(){
		
		return this.service.list();
	}
}
