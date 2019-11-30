package com.charlie.service;

import java.util.List;

import com.charlie.api.Dept;

public interface DeptService {

	boolean addDept(Dept dept);
	
	Dept getDept(Long id);
	
	List<Dept> list();
}
