package com.charlie.service.feign;

import java.util.List;

import org.springframework.stereotype.Component;

import com.charlie.api.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptFeignService>{

	@Override
	public DeptFeignService create(Throwable throwable) {
		// TODO Auto-generated method stub
		return new DeptFeignService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept getDeptById(long id) {
				// TODO Auto-generated method stub
				return new Dept(id, "name", "这是数据库，做的降级处理");
			}
		};
	}

}
