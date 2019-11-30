package com.charlie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.api.Dept;
import com.charlie.service.DeptService;

@RestController
@RequestMapping("/provider")
public class DeptController {

	@Autowired
	private DeptService service;
	
	@RequestMapping(value = "/find/dept/{id}", method = RequestMethod.GET)
	public Dept getDeptById(@PathVariable("id") long id) {
		
		return this.service.getDept(id);  
	}
	
	@RequestMapping(value = "/find/dept/list", method = RequestMethod.GET)
	public List<Dept> list(){
		
		return this.service.list();
	}
}
