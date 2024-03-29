package com.charlie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import com.rule.ribbon.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservices-dept",configuration = MySelfRule.class)
public class Application801 {

	public static void main(String[] args) {
		SpringApplication.run(Application801.class, args);
	}
}
