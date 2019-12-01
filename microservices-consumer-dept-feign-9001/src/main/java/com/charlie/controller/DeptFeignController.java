package com.charlie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlie.api.Dept;
import com.charlie.service.feign.DeptFeignService;

@RestController
@RequestMapping("/consumer/feign")
public class DeptFeignController {
	
	@Autowired
	private DeptFeignService service;
	
	@RequestMapping(value = "/find/dept/{id}", method = RequestMethod.GET)
	public Dept getDeptById(@PathVariable("id") long id) {

		return this.service.getDeptById(id);
	}

	@RequestMapping(value = "/find/dept/list", method = RequestMethod.GET)
	public List<Dept> getDeptList() {

		return this.service.list();
	}
}
