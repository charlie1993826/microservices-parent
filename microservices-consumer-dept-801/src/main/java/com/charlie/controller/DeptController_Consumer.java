package com.charlie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.charlie.api.Dept;

@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {
	
	private static final String URL = "http://localhost:8001/provider/";

	@Autowired
	private RestTemplate restTemlate;
	
	@RequestMapping(value = "/find/dept/{id}", method = RequestMethod.GET)
	public Dept getDeptById(@PathVariable("id") long id) {
		
		return this.restTemlate.getForObject(URL + "find/dept/" + id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/find/dept/list", method = RequestMethod.GET)
	public List<Dept> getDeptList() {
		
		return this.restTemlate.getForObject(URL + "find/dept/list", List.class);
	}
}
