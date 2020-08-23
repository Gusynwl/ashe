package com.hpl.ashe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan(value = "com.hpl.ashe.mapper.*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AsheApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AsheApplication.class);
		springApplication.run(args);

	}
	
}
