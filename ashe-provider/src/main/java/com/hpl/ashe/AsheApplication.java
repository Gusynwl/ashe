package com.hpl.ashe;

import com.hpl.ashe.listeners.AsheApplicationContextListeners;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.hpl.ashe.mapper.*")
@SpringBootApplication
public class AsheApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AsheApplication.class);
		springApplication.addListeners(new AsheApplicationContextListeners());
		springApplication.run(args);

	}
	
}
