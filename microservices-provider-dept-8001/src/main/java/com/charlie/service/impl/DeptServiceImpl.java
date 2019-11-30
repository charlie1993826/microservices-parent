package com.charlie.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charlie.api.Dept;
import com.charlie.mapper.DeptMapper;
import com.charlie.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper mapper;
	
	@Override
	public boolean addDept(Dept dept) {
		// TODO Auto-generated method stub
		if(this.mapper.insert(dept) > 0) return true;
		return false;
	}

	/**
	 * 根据ID查询数据
	 */
	@Override
	public Dept getDept(Long id) {
		// TODO Auto-generated method stub
		return this.mapper.selectById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		QueryWrapper<Dept> wrapper = new QueryWrapper<Dept>();
		List<Dept> list = this.mapper.selectList(wrapper);
		return list;
	}

}
