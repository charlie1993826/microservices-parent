package com.charlie.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charlie.api.Dept;

//@FeignClient(value = "microservices-dept")
@FeignClient(value = "microservices-dept", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptFeignService {

	@RequestMapping(value = "/provider/find/dept/{id}", method = RequestMethod.GET)
	public Dept getDeptById(@PathVariable("id") long id);
	
	@RequestMapping(value = "/provider/find/dept/list", method = RequestMethod.GET)
	public List<Dept> list();
	
}
