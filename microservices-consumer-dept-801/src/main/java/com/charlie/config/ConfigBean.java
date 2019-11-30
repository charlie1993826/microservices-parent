package com.charlie.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

	/**
	 * 默认使用的是轮训算法
	 * @return
	 */
	@Bean
	@LoadBalanced//客户端的负载均衡工具，springcloud ribbon，使用它就是使用ribbon，ribbon默认使用的就是轮训算法
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 使用随机算法
	 * @return
	 
	@Bean
	public IRule myRule() {
		
//		return new RandomRule();//这是接口是随机算法
		return new RetryRule();//重试算法,如果出现问题了，在前几次访问的时候会去访问down了的服务 ，但是出现错误之后报错了几次，那么在后面的访问当中，就会不走down了的服务
	}*/
}
